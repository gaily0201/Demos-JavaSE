package com.zyg.db.utils;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ResourceBundle;
	public class DBUtils { 
	    private static final String DB_PROPERTY = "ora_db"; 
	    private static String drivers; 
	    private static String url; 
	    private static String user; 
	    private static String password; 
	    static { 
	        ResourceBundle res = ResourceBundle.getBundle(DB_PROPERTY); 
	        drivers = res.getString("DRIVERS").trim(); 
	        url = res.getString("URL").trim(); 
	        user = res.getString("USER").trim(); 
	        password = res.getString("PASSWORD").trim(); 
	        
	        
	    } 
	    public static Connection getConnection() throws SQLException { 
	        Connection conn = null; 
	        try { 
	            Class.forName(drivers).newInstance(); 
	            conn = DriverManager.getConnection(url, user, password); 
	        } catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
	        if (conn == null) { 
	            throw new SQLException("ctcjz.DBUtils: Cannot get connection."); 
	        } 
	        return conn; 
	    } 
	    
	    public static void close(Connection conn) { 
	        if (conn == null) 
	            return; 
	        try { 
	            conn.close(); 
	        } catch (SQLException e) { 
	            System.out.println("ctcjz.DBUtils: Cannot close connection."); 
	        } 
	    } 
	    public static void close(Statement stmt) { 
	        try { 
	            if (stmt != null) { 
	                stmt.close(); 
	            } 
	        } catch (SQLException e) { 
	            System.out.println("ctcjz.DBUtils: Cannot close statement."); 
	        } 
	    } 
	    public static void close(ResultSet rs) { 
	        try { 
	            if (rs != null) { 
	                rs.close(); 
	            } 
	        } catch (SQLException e) { 
	            System.out.println("ctcjz.DBUtils: Cannot close resultset."); 
	        } 
	    } 
	} 