package com.buildxml.area.utils;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ResourceBundle;
	public class DBUtils { 
	    private static final String drivers = "oracle.jdbc.driver.OracleDriver"; 
	    private static final String url = "jdbc:oracle:thin:@192.168.6.75:1521:ctcmc"; 
	    private static String user = "gsw"; 
	    private static String password = "gsw_fhwlcatv"; 

	    public static Connection getConnection() throws SQLException { 
	        Connection conn = null; 
	        try { 
	            Class.forName(drivers).newInstance(); 
	            conn = DriverManager.getConnection(url, user, password); 
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	        if (conn == null) { 
	            throw new SQLException("Cannot get connection."); 
	        } 
	        return conn; 
	    } 
	    
	    public static void close(Connection conn) { 
	        if (conn == null) 
	            return; 
	        try { 
	            conn.close(); 
	        } catch (SQLException e) { 
	            System.out.println("Cannot close connection."); 
	        } 
	    } 
	    public static void close(Statement stmt) { 
	        try { 
	            if (stmt != null) { 
	                stmt.close(); 
	            } 
	        } catch (SQLException e) { 
	            System.out.println("Cannot close statement."); 
	        } 
	    } 
	    public static void close(ResultSet rs) { 
	        try { 
	            if (rs != null) { 
	                rs.close(); 
	            } 
	        } catch (SQLException e) { 
	            System.out.println("Cannot close resultset."); 
	        } 
	    } 
	} 