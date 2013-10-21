/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.zyg.db.mytest;

import java.sql.Connection;

public class Main {
	public static void main(String[] args) {
		String db_property = "mssql_db.properties";
		ConnectionPool connPool = new ConnectionPool(db_property);
		try {
			connPool.createPool();
			for(int i=0;i<10;i++){
				Connection conn = connPool.getConnection();
				System.out.println("conn-"+i+":"+conn);
				//用完返回连接
				connPool.returnConnection(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}