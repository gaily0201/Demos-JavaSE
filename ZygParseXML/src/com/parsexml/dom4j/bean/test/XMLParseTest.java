package com.parsexml.dom4j.bean.test;

import java.util.HashMap;
import java.util.Map;

public class XMLParseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ��ȡ������ݷŵ����map��
		Map<String, Bean> beansMap = new HashMap<String, Bean>();
		
		String fileName = "applicationContext.xml";
		
		beansMap = XMLParse.readXmlFile(fileName);
		
		System.out.println(beansMap.size());
	}

}
