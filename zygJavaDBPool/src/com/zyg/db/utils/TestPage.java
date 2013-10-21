package com.zyg.db.utils;

import java.sql.SQLException;
import java.sql.*;

public class TestPage {
	public static void main(String[] args){
		try {
			Connection conn = null; 			//����Connection����
			PreparedStatement pstmt = null; 	//����PreparedStatement����
			ResultSet rs = null;			 	//����ResultSet����
			
			int P_CURPAGE = 3;					//��ǰҳ
			int P_PAGESIZE = 2;					//ÿҳ��С
			String P_TABLENAME = "USERS";		//������
			String P_WHERE = null;				//����
			String P_TABLECOLUMN = "username,userpass";//������
			String P_ORDER = "username desc";				//����
			int P_ROWCOUNT = 0;					//������
			int P_PAGECOUNT = 0;				//��ҳ��
			
			conn = DBUtils.getConnection();
			CallableStatement cstmt 
				= conn.prepareCall("{ call PACKAGE_PAGE.PROC_PAGE(?,?,?,?,?,?,?,?,?) }");
			
			//���ò���
			cstmt.setInt(1, P_CURPAGE);
			cstmt.setInt(2, P_PAGESIZE);
			cstmt.setString(3, P_TABLENAME);
			cstmt.setString(4, P_WHERE);
			cstmt.setString(5, P_TABLECOLUMN);
			cstmt.setString(6, P_ORDER);
			
			//ע���������
			cstmt.registerOutParameter(7,java.sql.Types.INTEGER );
			cstmt.registerOutParameter(8,java.sql.Types.INTEGER );
			cstmt.registerOutParameter(9, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			
			//��ȡ����ֵ
			P_ROWCOUNT = cstmt.getInt(7);
			P_PAGECOUNT = cstmt.getInt(8);
			rs =  (ResultSet)cstmt.getObject(9);//��9��?������Ĳ���
			
			//��ӡ���ֵ
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
