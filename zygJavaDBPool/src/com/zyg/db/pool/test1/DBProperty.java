package com.zyg.db.pool.test1;

import java.util.Properties;
import java.io.*;

public class DBProperty {
	/**
	 * �������ݿ��JDBC������������
	 */
	private String className;
	/**
	 * ���ݿ������ַ���
	 */
	private String url;
	/**
	 * ���ݿ��ʺ�
	 */
	private String user;
	/**
	 * ���ݿ�����
	 */
	private String password;
	/**
	 * ����ص�������Ӹ���
	 */
	private int maxConn;
	/**
	 * ����ص���С���Ӹ���
	 */
	private int minConn;
	/**
	 * ÿ�����ӵ�������ø���
	 */
	private int maxRefNum;
	/**
	 * ���������ʱ���ͻ��˵����ȴ�ʱ�䣬����������ȴ�ʱ�� ���������û�п�������ʱ�������޿��������쳣
	 */
	private int maxWaitTime;
	/**
	 * ��ȡ�����ļ�����
	 */
	private Properties pro = new Properties();
	/**
	 * �Ƿ�Ϊ����ģʽ
	 */
	private boolean isDebug = false;

	/**
	 * ��DB.properties�ж�ȡ������Ϣ����ʼ����������
	 */
	public DBProperty() {
		initAllPropertiesFromFile();
	}

	/**
	 * ��������
	 */
	public String getClassName() {
		return className;
	}

	
	/**
	 * �������ļ������³�ʼ����������
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
	 * ��ȡ�����ļ�
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
	 * ����������������
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
	 * ���ļ��ж�ȡĳ���ض������ԡ�
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
