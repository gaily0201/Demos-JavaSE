package com.cn;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {


	public static void main(String[] args) {
		System.out.println("abc".matches("..."));
		System.out.println("a88887tt02y444k4a".replaceAll("\\d", "-")); /* d�������һ�����֣� java��������б�ܴ���һ����б�ܱ�ʾת��*/
		


		
		Pattern p = Pattern.compile("[a-z]{3}");/*Pattern�Ǳ���õ�ƥ��ģʽ��ƥ�����3���ַ����ַ���������ÿ���ַ����Ǵӣ�a-z���������ĸ*/
		Matcher m = p.matcher("fgh"); /*Matcher����ƥ������ƥ���ַ���*/
		System.out.println("m.matches()===="+m.matches());/*matches:��ʾ��ƥ�仹�ǲ�ƥ��*/
		
		
		System.out.println("fga".matches("[a-z]{3}")); /*�ȼ���������仰*/
		
		
		
		
		
		
		
	}

}
