package com.cn;

public class test5 {

	public static void main(String[] args) {
		//unix����һ�ױ�׼      . ���������ַ�
		
		//�߽�ƥ�䣺
		System.out.println("hello sir".matches("^h.*")); /*^����һ�еĿ�ͷ����h��ͷ.��������κ��ַ���*�������0�������ַ�*/
		System.out.println("hello sir".matches(".*"));
		System.out.println("hello sir".matches(".*ir$"));
		System.out.println("sir".matches(".*ir$")); 
		System.out.println("111111111111111111111111111111111111111111111111");
		
		
		System.out.println("hello sir".matches("^h[a-z]{1,3}o\\b.*")); /*\\b:��ʾ���ʱ߽磺�������һ�����ʵĿո�*/
		System.out.println("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
		System.out.println("2222222222222222222222222222222222222222222222222");
		
		//�հ��У�
		System.out.println(" \n".matches("^[\\s&&[^\\n]]*\\n$")); /*\\s:��ʾ��ʼ����һ���հ��ַ���&&[^\\n]]��ʾ�����Ҹÿհ��ַ����ǻ��з���$��ʾ�Ѿ����е�ĩβ��*/
		System.out.println("aaa 8888c".matches(".*\\d{4}."));
		System.out.println("3333333333333333333333333333333333333333333333333");
		
		
		
		System.out.println("aaa 8888".matches(".*\\b\\d{3}.")); /*(.*)��ʾһ�������ַ�*/
		System.out.println("aaa8888c".matches(".*\\d{4}."));
		System.out.println("4444444444444444444444444444444444444444444444444");
		
		System.out.println("aaa8888c".matches(".*\\b\\d{4}."));
		

	}

}
