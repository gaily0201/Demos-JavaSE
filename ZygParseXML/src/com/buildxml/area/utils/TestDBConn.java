package com.buildxml.area.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDBConn {
	public static void main(String[] args) throws Exception{
		String url = "jdbc:oracle:thin:@192.168.6.75:1521:ctcmc";   
        String username ="gsw";   
        String password = "gsw_fhwlcatv";   
        Long startTime = System.currentTimeMillis();   
        
        String sql = "select * from city";
        for(int i=0;i<141;i++){   
            try{   
            Class.forName("oracle.jdbc.driver.OracleDriver");   
            }catch(ClassNotFoundException e){   
                e.printStackTrace();   
            }   
            Connection conn = DriverManager.getConnection(url,username,password);   
            Statement stmt = conn.createStatement();//������������  
            
            ResultSet rs = stmt.executeQuery(sql);   
            while(rs.next()){   
                //ִ��ָ�������   
            }   
            rs.close();   
            stmt.close();   
            conn.close();   
        }   
        System.out.println("����100��ѭ������"+(System.currentTimeMillis()-startTime)+"ms");  
	}
}
