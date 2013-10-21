/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zyg.db.pool.test2;

import java.sql.Connection;

/**
 *
 * @author root
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@192.168.6.75:1521:ctcmc";
		String dbUsername = "gsw";
		String dbPassword = "gsw_fhwlcatv";
		
		ConnectionPool connPool 
        = new ConnectionPool(jdbcDriver,dbUrl,dbUsername,dbPassword);
		
		try {
			connPool.createPool();
			for(int i=0;i<1000;i++){
				Connection conn = connPool.getConnection();
				System.out.println("conn-"+i+":"+conn);
				//返回连接
				connPool.returnConnection(conn);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}