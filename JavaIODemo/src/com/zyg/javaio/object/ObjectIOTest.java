package com.zyg.javaio.object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class ObjectIOTest {

	/**
	 * @author �����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "D:/NewStudy/JavaIODemo/objio.txt";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		Person p = new Person("�����",24, new Date(1984,5,22));
		try {
			//��ʼ�����
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			//������д�����ļ���
			p.setAge(26);
			p.setName("ţţ");
			writePerson(oos, p);
			
			p.setName("ţţ");
			writePerson(oos, p);
			//�ر������
			oos.close();
			
			//��ʼ������
			fis = new FileInputStream(filePath);
			ois = new ObjectInputStream(fis);
			p = readPerson(ois);
			System.out.println(p.getName()+"->"+p.getAge()+"->"+p.getBirthday());
			
			p = readPerson(ois);
			System.out.println(p.getName()+"->"+p.getAge()+"->"+p.getBirthday());
			//�ر�������
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("����ִ����ϣ�");
	}
	
	private static Person readPerson(ObjectInputStream ois){
		//public interface Externalizableextends Serializable
		Person p = null;
		try {
			p = (Person)ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	private static void writePerson(ObjectOutputStream oos,Person p){
		try {
			oos.writeObject(p);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


class Person implements Serializable{
	private String name;
	private transient int age;
	private Date birthday;
	
	Person(){
		
	}
	
	Person(String name,int age,Date birthday){
		this.name=name;
		this.age=age;
		this.birthday=birthday;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
