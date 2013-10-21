package com.zyg.db.pool.test1;

import java.util.Properties;
import java.io.*;

public class DBProperty {
	/**
	 * 连接数据库的JDBC驱动程序类名
	 */
	private String className;
	/**
	 * 数据库连接字符串
	 */
	private String url;
	/**
	 * 数据库帐号
	 */
	private String user;
	/**
	 * 数据库密码
	 */
	private String password;
	/**
	 * 缓冲池的最大连接个数
	 */
	private int maxConn;
	/**
	 * 缓冲池的最小连接个数
	 */
	private int minConn;
	/**
	 * 每个连接的最大引用个数
	 */
	private int maxRefNum;
	/**
	 * 当缓冲池满时，客户端的最大等待时间，如果超过最大等待时间 ，而缓冲池没有空闲连接时，返回无空闲连接异常
	 */
	private int maxWaitTime;
	/**
	 * 读取属性文件的类
	 */
	private Properties pro = new Properties();
	/**
	 * 是否为调试模式
	 */
	private boolean isDebug = false;

	/**
	 * 从DB.properties中读取属性信息，初始化各个属性
	 */
	public DBProperty() {
		initAllPropertiesFromFile();
	}

	/**
	 * 返回类名
	 */
	public String getClassName() {
		return className;
	}

	
	/**
	 * 从属性文件中重新初始化各个属性
	 */
	private void initAllPropertiesFromFile() {
		readPropertyFile();
		className = getProperty("className");
		user = getProperty("user");
		password = getProperty("password");
		url = getProperty("url");
		maxConn = Integer.parseInt(getProperty("maxConn"));
		minConn = Integer.parseInt(getProperty("minConn"));
		maxRefNum = Integer.parseInt(getProperty("maxRefNum"));
		maxWaitTime = Integer.parseInt(getProperty("maxWaitTime"));
		isDebug = Boolean.parseBoolean(getProperty("isDebug"));
		if (this.isDebug()){
			pro.list(System.out);
		}
	}
	
	/**
	 * 读取属性文件
	 */
	private void readPropertyFile() {
		InputStream in;
		try {
			in = Class.forName(DBProperty.class.getName())
					.getResourceAsStream("DB.properties");
			pro.load(in);
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 重新设置类名参数
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDebug() {
		return isDebug;
	}
	
	/**
	 * 从文件中读取某个特定的属性。
	 */
	private String getProperty(String strPro) {
		return pro.getProperty(strPro);
	}

	public int getMaxConn() {
		return maxConn;
	}

	public int getMinConn() {
		return minConn;
	}

	public int getMaxRefNum() {
		return maxRefNum;
	}

	public int getMaxWaitTime() {
		return maxWaitTime;
	}

	public void setMaxConn(int maxConn) {
		this.maxConn = maxConn;
	}

	public void setMinConn(int minConn) {
		this.minConn = minConn;
	}

	public void setMaxRefNum(int maxRefNum) {
		this.maxRefNum = maxRefNum;
	}

	public void setMaxWaitTime(int maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}
}
