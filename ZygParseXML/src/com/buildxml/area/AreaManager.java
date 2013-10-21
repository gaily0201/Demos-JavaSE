package com.buildxml.area;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.buildxml.pool.test.DBConnectionPoolMgr;

public class AreaManager {
	private DBConnectionPoolMgr dbmgr = new DBConnectionPoolMgr();
	/**
	 * ��ѯ����ʡ������
	 * @return
	 */
	public List getProvinces(){
		List<AreaInfo> provinceList = new ArrayList<AreaInfo>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = DBUtils.getConnection();
			conn = dbmgr.getFreeConnection();
			String sql = "select provinceno,provincename from province order by provinceno";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AreaInfo areaInfo = new AreaInfo();
				areaInfo.setAreaNo(rs.getString(1));
				areaInfo.setAreaName(rs.getString(2));
				
				provinceList.add(areaInfo);
			}
			//�ر���Դ
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//�ر�����
			dbmgr.closeConnection(conn);
		}
		
		return provinceList;
	}
	
	/**
	 * ����ʡ�ݱ�Ų�ѯ���еؼ���
	 * @param provinceNo
	 * @return
	 */
	public List getCitiesByProvinceNo(String provinceNo){
		List<AreaInfo> cityList = new ArrayList<AreaInfo>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = DBUtils.getConnection();
			conn = dbmgr.getFreeConnection();
			String sql = "select cityno,cityname from city where provinceno=? order by cityno";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, provinceNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AreaInfo areaInfo = new AreaInfo();
				areaInfo.setAreaNo(rs.getString(1));
				areaInfo.setAreaName(rs.getString(2));
				cityList.add(areaInfo);
			}
			//�ر���Դ
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//�ر�����
			dbmgr.closeConnection(conn);
		}
		
		return cityList;
	}
	
	/**
	 * ���ݵؼ��б�Ų�ѯ������
	 * @param provinceNo
	 * @return
	 */
	public List getCountriesByCityNo(String cityNo){
		List<AreaInfo> countryList = new ArrayList<AreaInfo>();
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
//			conn = DBUtils.getConnection();
			conn = dbmgr.getFreeConnection();
			String sql = "select countryno,countryname from country where cityno=? order by countryno";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cityNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				AreaInfo areaInfo = new AreaInfo();
				areaInfo.setAreaNo(rs.getString(1));
				areaInfo.setAreaName(rs.getString(2));
				//System.out.println(rs.getString(2));
				countryList.add(areaInfo);
			}
			//�ر���Դ
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//�ر�����
			dbmgr.closeConnection(conn);
		}
		
		return countryList;
	}
}
