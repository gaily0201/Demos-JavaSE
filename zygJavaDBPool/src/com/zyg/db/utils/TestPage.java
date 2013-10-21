package com.zyg.db.utils;

import java.sql.SQLException;
import java.sql.*;

public class TestPage {
	public static void main(String[] args){
		try {
			Connection conn = null; 			//声明Connection对象
			PreparedStatement pstmt = null; 	//声明PreparedStatement对象
			ResultSet rs = null;			 	//声明ResultSet对象
			
			int P_CURPAGE = 3;					//当前页
			int P_PAGESIZE = 2;					//每页大小
			String P_TABLENAME = "USERS";		//表名称
			String P_WHERE = null;				//条件
			String P_TABLECOLUMN = "username,userpass";//列名称
			String P_ORDER = "username desc";				//排序
			int P_ROWCOUNT = 0;					//总行数
			int P_PAGECOUNT = 0;				//总页数
			
			conn = DBUtils.getConnection();
			CallableStatement cstmt 
				= conn.prepareCall("{ call PACKAGE_PAGE.PROC_PAGE(?,?,?,?,?,?,?,?,?) }");
			
			//设置参数
			cstmt.setInt(1, P_CURPAGE);
			cstmt.setInt(2, P_PAGESIZE);
			cstmt.setString(3, P_TABLENAME);
			cstmt.setString(4, P_WHERE);
			cstmt.setString(5, P_TABLECOLUMN);
			cstmt.setString(6, P_ORDER);
			
			//注册输出参数
			cstmt.registerOutParameter(7,java.sql.Types.INTEGER );
			cstmt.registerOutParameter(8,java.sql.Types.INTEGER );
			cstmt.registerOutParameter(9, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			
			//获取返回值
			P_ROWCOUNT = cstmt.getInt(7);
			P_PAGECOUNT = cstmt.getInt(8);
			rs =  (ResultSet)cstmt.getObject(9);//第9个?所代表的参数
			
			//打印输出值
			System.err.println("rows:"+P_ROWCOUNT);
			System.err.println("pages:"+P_PAGECOUNT);
			
			ResultSetMetaData rmd =rs.getMetaData(); 
			while(rs.next()){ 
				for(int i=0;i<rmd.getColumnCount();i++){ 
				  System.out.print(rs.getString(i+1)+" "); 
				} 
				System.out.println(""); 
			} 
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
