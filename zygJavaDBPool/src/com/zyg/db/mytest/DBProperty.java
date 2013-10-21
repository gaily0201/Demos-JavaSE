package com.zyg.db.mytest;

import java.io.InputStream;
import java.util.Properties;

public class DBProperty {
	private String jdbcDriver; 			// ���ݿ�����
	private String dbUrl; 				// ���� URL
	private String dbUsername;			// ���ݿ��û���
	private String dbPassword; 			// ���ݿ��û�����
	private String testTable; 			// ���������Ƿ���õĲ��Ա�����Ĭ��û�в��Ա�
	private int initialConnections; 	// ���ӳصĳ�ʼ��С
	private int incrementalConnections; // ���ӳ��Զ����ӵĴ�С
	private int maxConnections; 		// ���ӳ����Ĵ�С
	//��ȡ�����ļ�����
	private Properties pro = new Properties();
	
	/**
	 * �������ļ��ж�ȡ������Ϣ����ʼ����������
	 */
	public DBProperty(String dbPropertyFile) {
		initAllPropertiesFromFile(dbPropertyFile);
	}
	
	/**
	 * �������ļ������³�ʼ����������
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
	 * ��ȡ�����ļ�
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
	 * ���ļ��ж�ȡĳ���ض������ԡ�
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
	 * �������ӳصĳ�ʼ��С
	 * @return ��ʼ���ӳ��пɻ�õ���������
	 */
	public int getInitialConnections() {
		return this.initialConnections;
	}

	/**
	 * �������ӳصĳ�ʼ��С
	 * @param �������ó�ʼ���ӳ������ӵ�����
	 */
	public void setInitialConnections(int initialConnections) {
		this.initialConnections = initialConnections;
	}

	/**
	 * �������ӳ��Զ����ӵĴ�С ��
	 * 
	 * @return ���ӳ��Զ����ӵĴ�С
	 */
	public int getIncrementalConnections() {
		return this.incrementalConnections;
	}

	/**
	 * �������ӳ��Զ����ӵĴ�С
	 * @param ���ӳ��Զ����ӵĴ�С
	 */
	public void setIncrementalConnections(int incrementalConnections) {
		this.incrementalConnections = incrementalConnections;
	}

	/**
	 * �������ӳ������Ŀ�����������
	 * 
	 * @return ���ӳ������Ŀ�����������
	 */
	public int getMaxConnections() {
		return this.maxConnections;
	}

	/**
	 * �������ӳ��������õ���������
	 * @param �������ӳ��������õ���������ֵ
	 */
	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	/**
	 * ��ȡ�������ݿ�������
	 * 
	 * @return �������ݿ�������
	 */
	public String getTestTable() {
		return this.testTable;
	}

	/**
	 * ���ò��Ա������
	 * 
	 * @param testTable String ���Ա������
	 */
	public void setTestTable(String testTable) {
		this.testTable = testTable;
	}
}
