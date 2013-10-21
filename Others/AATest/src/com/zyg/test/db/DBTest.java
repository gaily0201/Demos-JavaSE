package com.zyg.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTest {

	public static Connection connection = null;
	private static String DriverString = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	
	private static String url = "jdbc:microsoft:sqlserver://127.0.0.1:1433;databasename=pubs";

	public static String user = "sa";

	public static String password = "123456";
	
	public static void main(String[] args) {
		try {
			Class.forName(DriverString);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println(connection);
		} catch (SQLException ex) {
			ex.printStackTrace();
			connection = null;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			connection = null;
		}
	
	}

}
