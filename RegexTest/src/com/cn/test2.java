package com.cn;

public class test2 {

	public static void main(String[] args) {
//������ʶ. * + ?
//.�������һ���ַ�    *�������0�������ַ� ��+�������1�������ַ���   ?�������һ����0���ַ�
//(.*)��ʾһ�������ַ�.		
		System.out.println("a".matches("."));
		System.out.println("aa".matches("aa"));
		System.out.println("111111111111111111111111111111111111111111111111");
		
		System.out.println("aaaa".matches("a*"));
		System.out.println("aaaa".matches("a+"));
		System.out.println("2222222222222222222222222222222222222222222222222");
		
		System.out.println("".matches("a*"));
		System.out.println("aaaa".matches("a+"));
		System.out.println("3333333333333333333333333333333333333333333333333");
		
		System.out.println("".matches("a?"));
		System.out.println("a".matches("a?"));
		System.out.println("4444444444444444444444444444444444444444444444444");
		
		System.out.println("214523145234532".matches("\\d{3,100}")); /*��ʾ����һ�������������Σ�������100�Σ�Ҳ����3λ��100λ������*/
		System.out.println("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")); /*java��������б�ܴ���һ����б�ܱ�ʾת��*/
		System.out.println("192".matches("[0-2][0-9][0-9]")); /*[�йҺű�ʾ��Χ����һ������0��2�ķ�Χ,�ڶ�������0��9�ķ�Χ......]*/
	}

}
