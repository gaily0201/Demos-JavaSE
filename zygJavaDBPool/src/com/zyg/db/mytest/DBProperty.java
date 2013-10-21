package com.zyg.db.mytest;

import java.io.InputStream;
import java.util.Properties;

public class DBProperty {
	private String jdbcDriver; 			// 数据库驱动
	private String dbUrl; 				// 数据 URL
	private String dbUsername;			// 数据库用户名
	private String dbPassword; 			// 数据库用户密码
	private String testTable; 			// 测试连接是否可用的测试表名，默认没有测试表
	private int initialConnections; 	// 连接池的初始大小
	private int incrementalConnections; // 连接池自动增加的大小
	private int maxConnections; 		// 连接池最大的大小
	//读取属性文件的类
	private Properties pro = new Properties();
	
	/**
	 * 从配置文件中读取属性信息，初始化各个属性
	 */
	public DBProperty(String dbPropertyFile) {
		initAllPropertiesFromFile(dbPropertyFile);
	}
	
	/**
	 * 从属性文件中重新初始化各个属性
	 */
	private void initAllPropertiesFromFile(String dbPropertyFile){
		readPropertyFromFile(dbPropertyFile);
		jdbcDriver = getProperty("jdbcDriver");
		dbUrl = getProperty("dbUrl");
		dbUsername = getProperty("dbUsername");
		dbPassword = getProperty("dbPassword");
		testTable = getProperty("testTable");
		initialConnections = Integer.valueOf(getProperty("initialConnections"));
		incrementalConnections = Integer.valueOf(getProperty("incrementalConnections"));
		maxConnections = Integer.valueOf(getProperty("maxConnections"));
	}
	
	/**
	 * 读取属性文件
	 */
	private void readPropertyFromFile(String dbPropertyFile){
		InputStream in = null;
		try {
			in = Class.forName(DBProperty.class.getName())
				.getResourceAsStream(dbPropertyFile);
			pro.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 从文件中读取某个特定的属性。
	 */
	private String getProperty(String strPro) {
		return pro.getProperty(strPro);
	}
	
	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	/**
	 * 返回连接池的初始大小
	 * @return 初始连接池中可获得的连接数量
	 */
	public int getInitialConnections() {
		return this.initialConnections;
	}

	/**
	 * 设置连接池的初始大小
	 * @param 用于设置初始连接池中连接的数量
	 */
	public void setInitialConnections(int initialConnections) {
		this.initialConnections = initialConnections;
	}

	/**
	 * 返回连接池自动增加的大小 、
	 * 
	 * @return 连接池自动增加的大小
	 */
	public int getIncrementalConnections() {
		return this.incrementalConnections;
	}

	/**
	 * 设置连接池自动增加的大小
	 * @param 连接池自动增加的大小
	 */
	public void setIncrementalConnections(int incrementalConnections) {
		this.incrementalConnections = incrementalConnections;
	}

	/**
	 * 返回连接池中最大的可用连接数量
	 * 
	 * @return 连接池中最大的可用连接数量
	 */
	public int getMaxConnections() {
		return this.maxConnections;
	}

	/**
	 * 设置连接池中最大可用的连接数量
	 * @param 设置连接池中最大可用的连接数量值
	 */
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	/**
	 * 获取测试数据库表的名字
	 * 
	 * @return 测试数据库表的名字
	 */
	public String getTestTable() {
		return this.testTable;
	}

	/**
	 * 设置测试表的名字
	 * 
	 * @param testTable String 测试表的名字
	 */
	public void setTestTable(String testTable) {
		this.testTable = testTable;
	}
}
