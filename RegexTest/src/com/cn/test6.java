package com.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test6 {

	public static void main(String[] args) {
		//email
		//[\\w[.-]]:��ʾ�κ��ַ����һ�����.������-(�е�email��ַǰ������.-��)
		//+����ʾ����ĳ���һ�λ��Ρ�
		System.out.println("zhangsan@yahoo.com".matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$"));
		System.out.println("111111111111111111111111111111111111111111111111");

		//matches find lookingAt
		Pattern p = Pattern.compile("\\d{3,5}"); /*���ֳ���3--5��*/
		String s = "123-34345-234-00"; 
		Matcher m = p.matcher(s); 
		System.out.println("m.matches()======="+m.matches());/*matches:��ƥ�������ַ�����һ�γ�5���ַ�ȥƥ��*/
		System.out.println("2222222222222222222222222222222222222222222222222");
		
		m.reset(); /*�ַ���ɨ���λ������Ĵ�ͷ��ʼɨ��*/
		System.out.println("m.find()===="+m.find()); /*��һ��ƥ����ִ������������ַ���*/
		System.out.println(m.start() + "-" + m.end());
		System.out.println("3333333333333333333333333333333333333333333333333");

		
		System.out.println("4444444444444444444444444444444444444444444444444444");
		System.out.println(m.lookingAt()); /*ÿ�δ�ͷ��ƥ����Ӵ�*/
		System.out.println(m.lookingAt());
		System.out.println(m.lookingAt());
		System.out.println(m.lookingAt());
	}

}
