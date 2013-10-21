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
	 * ����XML�ļ���Ϣ��������Ϣ����map�С�
	 */
	
	public static Map<String,Student> ParseXMLFile(String fileName){
		// ��ȡ������ݷŵ����map��
		Map<String,Student> StudentsMap  = new HashMap<String,Student>();
		
		//��ô���classpath·�����ļ�����
		fileName = Thread.currentThread().getContextClassLoader()
				.getResource(fileName).getPath().substring(1);
		
		System.out.println("fileName:"+fileName);
		
		//���ļ�
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(new File(fileName));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ��λ���е�student
		Iterator<?> studentsIterator = doc.getRootElement()
									.elementIterator("student");
		while(studentsIterator.hasNext()){
			Element studentElm = (Element)studentsIterator.next();
			//ÿ��student����Ϣ�ŵ�һ��Studentʵ����
			Student stu = new Student();
			
			String stuId = studentElm.attributeValue("id");
//			String stuId = studentElm.attribute("id").getStringValue();
			
			String stuName = studentElm.attributeValue("name");
//			String stuName = studentElm.attribute("name").getStringValue();
			
			stu.setId(stuId);
			stu.setName(stuName);
			
//			System.out.println("Student.name:"+stu.getName());
			
			//student����book��ǩ
			if (studentElm.elements().size() > 0) {
				Element booksListElm = (Element)studentElm.elements().get(0);
				Iterator<?> booksIterator = booksListElm.elementIterator("book");
				
				while(booksIterator.hasNext()){
					Element bookElm = (Element)booksIterator.next();
					//ÿ��book����Ϣ�ŵ�һ��Bookʵ����
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
