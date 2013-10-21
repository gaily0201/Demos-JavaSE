package com.zyg.db.pool.test1;

import java.sql.*;

public class DBConnection {
	/**
	 *  DBConnection类对Connection对象进行了包装。
	 */
	private Connection conn;
	/**
	 *  此连接的引入计数，也就是该连接被客户端使用的
	 *  次数，如果最大引入计数时，该连接被删除
	 */
	private int refNum = 0;
	/**
	 *  标识对象是否正在被客户端使用（是否空闲）
	 */
	private boolean isUsing = false;
	/**
	 * 是否启用调试
	 */
	private boolean isDebug = false;

	/**
	 *  在构造函数中实例化conn对象
	 */
	public DBConnection(String className, String url, String user,
			String password, boolean isDebug) {
		this.isDebug = isDebug;
		try {
			Class.forName(className).newInstance();
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			if (this.isDebug) {
				System.err.println("err in DBconnection.DBconnection():"
						+ e.getMessage());
				e.printStackTrace();
			}

		}
	}

	/**
	 *  释放此conn对象。包内可见。对使用的客户端不可见。
	 */
	void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			if (this.isDebug) {
				System.err.println("err in DBConnection.closeConnection():"
						+ e.getMessage());
				e.printStackTrace();
			}
		}

	}
	
	/**
	 *  返回客户端此Connection
	 */
	public Connection getConnection() {
		return conn;
	}

	public boolean isUsing() {
		return isUsing;
	}

	public void setUsing(boolean isUsing) {
		this.isUsing = isUsing;
	}

	public boolean isDebug() {
		return isDebug;
	}

	public void setRefNum(int refNum) {
		this.refNum = refNum;
	}

	public int getRefNum() {
		return refNum;
	}
}
