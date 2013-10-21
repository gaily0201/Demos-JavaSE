package com.parsexml.dom4j.student.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StudentXMLParseTest {
	public static void main(String[] args){
		
		String fileName="Students.xml";
		
		Map<String,Student> studentsMap = new HashMap<String,Student>();
		
		//����xml�ļ��������studentsMap��
		studentsMap = StudentXMLParse.ParseXMLFile(fileName);
		
		System.out.println("Students.xml�ļ��������----------------------");
		
		Iterator<?> stuIterator = studentsMap.keySet().iterator();
		
		while(stuIterator.hasNext()){
			Student stu = (Student)studentsMap.get(stuIterator.next());
			System.out.println("---------------------------------------");
			
			System.out.println("ѧ�� id��"+stu.getId()+" name:"+stu.getName());
			
			if (stu.getBooks()!= null){
				Iterator<?> bookIterator = stu.getBooks().keySet().iterator();
				while(bookIterator.hasNext()){
					Book book = (Book)stu.getBooks().get(bookIterator.next());
					
					System.out.println("�� id��"+book.getId()+" name:"+book.getName());
				}
			}
		}
	}
}
