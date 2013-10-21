package com.buildxml.area;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BuildAreaInfoXml {
	private static AreaManager areaManager = new AreaManager();
	private static final String filePath = "D:/areainfo.xml";
	private static final String xmlDeclaration = "<?xml version=\"1.0\" encoding=\"GBK\" ?>\n";
	private static final String tab = "\t";
	private static FileWriter fw = null;
	
	public static void main(String[] args){
		buildAreaInfoXmlFile();
	}
	
	public static void buildAreaInfoXmlFile(){
		try {
			fw = new FileWriter(filePath);
			//写入xml声明
			fw.write(xmlDeclaration);
			//写入省份节点
			writeProvinceNodes();
			
			fw.close();
			System.out.println("创建xml文件完毕！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void writeProvinceNodes(){
		List provinceList = areaManager.getProvinces();
		try {
			fw.write("<provinces version=\"1.0\">\n");
			String provinceNo = null;
			String provinceName = null;
			AreaInfo areaInfo = null;
			int length = provinceList.size();
			for(int i=0;i<length;i++){
				areaInfo = (AreaInfo)provinceList.get(i);
				provinceNo = areaInfo.getAreaNo();
				provinceName = areaInfo.getAreaName();
				
				StringBuffer provinceNode = new StringBuffer(tab);
				provinceNode.append("<province code=\"");
				provinceNode.append(provinceNo);
				provinceNode.append("\" name=\"");
				provinceNode.append(provinceName);
				provinceNode.append("\">");
				fw.write(provinceNode.toString());
				
				//写入地级市节点
				writeCityNodes(provinceNo);
				
				fw.write("</province>\n");
			
			}
			fw.write("</provinces>");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void writeCityNodes(String provinceNo){
		List cityList = areaManager.getCitiesByProvinceNo(provinceNo);
		try {
			String cityNo = null;
			String cityName = null;
			AreaInfo areaInfo = null;
			int length = cityList.size();
			for(int i=0;i<length;i++){
				areaInfo = (AreaInfo)cityList.get(i);
				cityNo = areaInfo.getAreaNo();
				cityName = areaInfo.getAreaName();
				StringBuffer cityNode = new StringBuffer(tab);
				cityNode.append(tab);
				cityNode.append("<city code=\"");
				cityNode.append(cityNo);
				cityNode.append("\" name=\"");
				cityNode.append(cityName);
				cityNode.append("\">");
				fw.write(cityNode.toString());
				
				//写入县级节点
				//writeCountryNodes(cityNo);
				
				fw.write("</city>\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void writeCountryNodes(String cityNo){
		List countryList = areaManager.getCountriesByCityNo(cityNo);
		try {
			String countryNo = null;
			String countryName = null;
			AreaInfo areaInfo = null;
			int length = countryList.size();
			for(int i=0;i<length;i++){
				areaInfo = (AreaInfo)countryList.get(i);
				countryNo = areaInfo.getAreaNo();
				countryName = areaInfo.getAreaName();
				
				StringBuffer countryNode = new StringBuffer(tab);
				countryNode.append(tab);
				countryNode.append(tab);
				countryNode.append("<country code=\"");
				countryNode.append(countryNo);
				countryNode.append("\" name=\"");
				countryNode.append(countryName);
				countryNode.append("\"/>\n");
				
				fw.write(countryNode.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
