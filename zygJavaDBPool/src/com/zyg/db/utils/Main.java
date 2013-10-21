package com.zyg.db.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		Connection conn;
		try {
			for(int i=0;i<10000;i++){
				conn = DBUtils.getConnection();
				conn.close();
				System.out.println("conn:"+i+":"+conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
