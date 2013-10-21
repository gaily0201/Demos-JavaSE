package com.parsexml.dom4j.bean.test;

import java.util.HashMap;
import java.util.Map;

public class XMLParseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 读取后的内容放到这个map中
		Map<String, Bean> beansMap = new HashMap<String, Bean>();
		
		String fileName = "applicationContext.xml";
		
		beansMap = XMLParse.readXmlFile(fileName);
		
		System.out.println(beansMap.size());
	}

}
