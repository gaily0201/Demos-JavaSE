package com.parsexml.test;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * java中解析XML文件
 * @author Administrator
 *
 */
public class XMLParse {

	public static void main(String[] args) {
		String fileName = "Users.xml";
		fileName = Thread.currentThread().getContextClassLoader()
					.getResource(fileName).getPath().substring(1);
		
		//File file = new File("Users.xml");
		
		File file = new File(fileName);
		
		System.out.println(fileName);
		Document doc = null;
		
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.parse(file);
		}catch(IOException ioe){
			System.out.println("不能找到xml文件");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		NodeList users = doc.getElementsByTagName("user");
		Element userElement;
		
		for (int i = 0; i < users.getLength(); i++) {
			userElement = (Element) users.item(i);
			String id = userElement.getAttribute("id");
			String name = doc.getElementsByTagName("name").item(i)
					.getFirstChild().getNodeValue();
			String age = doc.getElementsByTagName("age").item(i)
					.getFirstChild().getNodeValue();
			String sex = doc.getElementsByTagName("sex").item(i)
					.getFirstChild().getNodeValue();

			System.out.println(id + "->" + name + "->" + age + "->" + sex);
			System.out.println("*******************************************");
		}
	}

}
