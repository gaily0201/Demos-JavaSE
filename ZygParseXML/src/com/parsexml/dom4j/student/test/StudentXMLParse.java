package com.parsexml.dom4j.student.test;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class StudentXMLParse {
	
	/**
	 * 解析XML文件信息，并把信息放入map中。
	 */
	
	public static Map<String,Student> ParseXMLFile(String fileName){
		// 读取后的内容放到这个map中
		Map<String,Student> StudentsMap  = new HashMap<String,Student>();
		
		//获得带上classpath路径的文件名称
		fileName = Thread.currentThread().getContextClassLoader()
				.getResource(fileName).getPath().substring(1);
		
		System.out.println("fileName:"+fileName);
		
		//读文件
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(new File(fileName));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 定位所有的student
		Iterator<?> studentsIterator = doc.getRootElement()
									.elementIterator("student");
		while(studentsIterator.hasNext()){
			Element studentElm = (Element)studentsIterator.next();
			//每个student的信息放到一个Student实例中
			Student stu = new Student();
			
			String stuId = studentElm.attributeValue("id");
//			String stuId = studentElm.attribute("id").getStringValue();
			
			String stuName = studentElm.attributeValue("name");
//			String stuName = studentElm.attribute("name").getStringValue();
			
			stu.setId(stuId);
			stu.setName(stuName);
			
//			System.out.println("Student.name:"+stu.getName());
			
			//student下有book标签
			if (studentElm.elements().size() > 0) {
				Element booksListElm = (Element)studentElm.elements().get(0);
				Iterator<?> booksIterator = booksListElm.elementIterator("book");
				
				while(booksIterator.hasNext()){
					Element bookElm = (Element)booksIterator.next();
					//每个book的信息放到一个Book实例中
					Book book = new Book();
					String bookId = bookElm.attributeValue("id");
					String bookName = bookElm.attributeValue("name");
					
					book.setId(bookId);
					book.setName(bookName);
					
//					System.out.println("book.name:"+book.getName());
					
					stu.getBooks().put(book.getId(),book);
				}
			}
			
			StudentsMap.put(stu.getId(), stu);
		}
		return StudentsMap;
	}
}
