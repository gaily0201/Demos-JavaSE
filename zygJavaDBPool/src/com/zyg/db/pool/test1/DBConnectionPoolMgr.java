package com.zyg.db.pool.test1;

import java.util.*;
import java.sql.*;

public class DBConnectionPoolMgr {
	/**
	 * 从属性文件中读取连接数据库和初始化缓冲池的各种参数
	 */
	private DBProperty dbPro = new DBProperty();
	/**
	 * 用HashMap实现缓冲池，存储DBConnection对象
	 */
	private HashMap<Integer, DBConnection> conPool = new HashMap<Integer, DBConnection>();
	/**
	 * conPool的下一个插入关键字（key)
	 */
	private int insertKey = 0;

	/**
	 * 构造函数中初始化缓冲池
	 */
	public DBConnectionPoolMgr() {
		initConPool();
	}

	public DBProperty getDbPro() {
		return dbPro;
	}

	public void setDbPro(DBProperty dbPro) {
		this.dbPro = dbPro;
	}
	
	/**
	 * 初始化连接缓冲池（删除已有连接，建立新的连接到minConn个）。
	 */
	public void initConPool() {
		int i = 0;
		while (i < dbPro.getMinConn()) {
			//建立一个新的连接放入到连接池conPool中
			DBConnection addConn = this.getNewDBConnection();
			i++;
			conPool.put(insertKey++, addConn);

		}
		if (dbPro.isDebug()) {
			System.err.println("DBConnectionPoolMgr.initConnPool(),i=" + i);
		}

	}
	
	/**
	 * 从缓冲池中获取一个空闲连接(Connection 对象)
	 */
	synchronized public Connection getFreeConnection() {
		Integer key;
		DBConnection model = null;
		//获取连接池的关键字的迭代器
		Iterator<Integer> iteratorKeys = this.getIteratorKeys();
		ArrayList<Integer> removeKeys = new ArrayList<Integer>();
		int index = 0;
		
		/* 依次取出缓冲池中的每个DBConnection对象,判断是否为空闲，若为空闲
		，且当前的DBConnection对象的连接记数小于等于最大连接计数
		，则分配此DBConnection连接
		
		 如果连接计数大于此最大连接记录,则从缓冲池中删除此DBConnection连接
		 ，DBConnection对象则关闭其维护的Connection对象。
		*/
		while (iteratorKeys.hasNext()) {
			key = iteratorKeys.next();
			model = conPool.get(key);
			System.out.println("key:"+key+"->model:"+model.isUsing()
					+"->refNum:"+model.getRefNum()
					+"->conPool.size:"+conPool.size());
			
			if (dbPro.isDebug()) {
				System.err.println("***" + model.isUsing());
			}
			if (!model.isUsing()) {
				if (model.getRefNum() >= dbPro.getMaxRefNum()) {
					model.closeConnection();
					removeKeys.add(key);
					model = null;
					System.out.println("key:"+key+"达到最大引用次数，销毁！");
				} else {
					model.setRefNum(model.getRefNum() + 1);
					model.setUsing(true);
					//System.err.println("In getFreeConnection():model->"+key+"model.refNum(()"+model.getRefNum());
					
					if (dbPro.isDebug()) {
						System.err.println("ConnPool:" + conPool);
						System.err.print("In getFreeConnection():model->"
								+ model.toString() + "model.refNum(()"
								+ model.getRefNum());
					}
					System.out.println("break------------------");
					break;
				}
			} else {
				// 如果该连接正在使用，则将model置空
				model = null;
			}
		}
		
		// 清除引用计数超过最大计数的DBConnection。
		for (int k = 0; k < removeKeys.size(); k++) {
			conPool.remove(removeKeys.get(k));
		}

		// 如果当前缓冲池已用完，但已经打开的连接个数没有达到最大连接数，则为此连接新建一个连接，并把此连接加入连接池中。
		if (model == null && this.getOpendConnNum() < dbPro.getMaxConn()) {
			if (dbPro.isDebug()) {
				System.err.println("DBMgr.getFreeConn:opendConnNum"
						+ this.getOpendConnNum());
				System.err.println("DBMgr.getFreeConn:maxConn:"
						+ dbPro.getMaxConn());
			}
			model = this.getNewDBConnection();
			conPool.put(insertKey++, model);
			model.setUsing(true);
			System.out.println("新建一个连接，conPool.size:"+conPool.size());
		}
		// 如果连接池中的连接小于指定的最小连接个数，则生成一些新的连接。
		while (conPool.size() < dbPro.getMinConn()) {
			DBConnection addConn = this.getNewDBConnection();
			conPool.put(insertKey++, addConn);
			System.out.println("小于指定的最小连接个数,新建一个连接，conPool.size:"+conPool.size());
		}

		if (model != null){
			return model.getConnection();
		}
		
		// 如果没有空闲连接，则向客户端返回null
		return null;
	}
	
	/**
	 * 返回一个新的DBConnection对象
	 */
	private DBConnection getNewDBConnection() {
		return new DBConnection(dbPro.getClassName(), dbPro.getUrl(), dbPro
				.getUser(), dbPro.getPassword(), dbPro.isDebug());

	}
	
	/**
	 * 获取连接池的关键字的迭代器
	 * 
	 * @return
	 */
	private Iterator<Integer> getIteratorKeys() {
		Set<Integer> keysSet = conPool.keySet();
		Iterator<Integer> iteratorKeys = keysSet.iterator();
		return iteratorKeys;

	}
	
	/**
	 * 返回当前正在使用的连接数
	 */
	public int getActiveConnNum() {
		Integer key;
		int count = 0;
		DBConnection model = null;
		Iterator<Integer> iteratorKeys = this.getIteratorKeys();
		while (iteratorKeys.hasNext()) {
			key = iteratorKeys.next();
			model = conPool.get(key);
			if (model.isUsing()) {
				count++;
			}
		}
		return count;
	}

	/**
	 * 返回正在当前时刻已打开的连接数。
	 * 
	 * @return
	 */
	public int getOpendConnNum() {
		return conPool.size();
	}

	/**
	 * 清空缓冲池，释放所有的连接
	 */
	public void releaseAll() {
		Integer key;
		DBConnection model = null;
		Iterator<Integer> iteratorKeys = this.getIteratorKeys();
		while (iteratorKeys.hasNext()) {
			key = iteratorKeys.next();
			model = conPool.get(key);
			model.closeConnection();
		}
		conPool.clear();
		insertKey = 0;

	}

	/**
	 * 客户端逻辑关闭缓冲池，将conn对象重新放入缓冲池中， 并查找该Connection对象对应的DBConnection,标记该
	 * DBConnection 为空闲，如果引入计数超过最大引入计数 （maxRefCount），则删除该对象。如果缓冲池中
	 * DBConnection对象小于minCount,则建立多个新的连接。
	 */
	public void closeConnection(Connection conn) {
		Integer key;
		DBConnection model = null;
		Set<Integer> keysSet = conPool.keySet();
		Iterator<Integer> iteratorKeys = keysSet.iterator();
		while (iteratorKeys.hasNext()) {
			key = iteratorKeys.next();
			model = conPool.get(key);
			if (model.getConnection() == conn) {
				model.setUsing(false);
			}
		}

	}
	
	/**
	 * 重新设置缓冲池最大连接个数
	 */
	public void resetMaxConn(int maxConn) {
		dbPro.setMaxConn(maxConn);
	}

	/**
	 * 重新设置缓冲池最小连接个数
	 */
	public void resetMinConn(int minConn) {
		dbPro.setMinConn(minConn);
	}

	/**
	 * 重新设置缓冲池中每个连接的引用计数最大值
	 */
	public void resetMaxRefMum(int maxRefNum) {
		dbPro.setMaxRefNum(maxRefNum);
	}
}
