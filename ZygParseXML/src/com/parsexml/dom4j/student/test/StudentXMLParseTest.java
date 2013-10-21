package com.parsexml.dom4j.student.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StudentXMLParseTest {
	public static void main(String[] args){
		
		String fileName="Students.xml";
		
		Map<String,Student> studentsMap = new HashMap<String,Student>();
		
		//解析xml文件结果存入studentsMap中
		studentsMap = StudentXMLParse.ParseXMLFile(fileName);
		
		System.out.println("Students.xml文件解析结果----------------------");
		
		Iterator<?> stuIterator = studentsMap.keySet().iterator();
		
		while(stuIterator.hasNext()){
			Student stu = (Student)studentsMap.get(stuIterator.next());
			System.out.println("---------------------------------------");
			
			System.out.println("学生 id："+stu.getId()+" name:"+stu.getName());
			
			if (stu.getBooks()!= null){
				Iterator<?> bookIterator = stu.getBooks().keySet().iterator();
				while(bookIterator.hasNext()){
					Book book = (Book)stu.getBooks().get(bookIterator.next());
					
					System.out.println("书 id："+book.getId()+" name:"+book.getName());
				}
			}
		}
	}
}
