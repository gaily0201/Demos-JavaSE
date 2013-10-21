package com.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test10 {

	//������Java��ͷ,�����β���ַ���
	public static  void fun1()
	{
		 Pattern pattern = Pattern.compile("^Java.*");
		  Matcher matcher = pattern.matcher("Java������");
		  boolean b= matcher.matches();
		  System.out.println("b=="+b);
	}
	
	
	//�Զ������ָ��ַ���ʱ:�Զ���(,)���ߺ�(|)���ָ��ַ��� 
	public static  void fun2()
	{
	Pattern pattern = Pattern.compile("[,|]");
	String[] strs = pattern.split("Java Hello World  Java,Hello,   ,World|Sun");
	for (int i=0;i<strs.length;i++) {
	    System.out.println(strs[i]);
	}

	}
	
	//�Զ������ָ��ַ���ʱ:�Զ���(�ո�)(,)���ߺ�(|)���ָ��ַ��� 
	public static  void fun3()
	{
		Pattern pattern = Pattern.compile("[ ,|]");
		String[] strs = pattern.split("Java Hello World  Java,Hello,   ,World|Sun");
		for (int i=0;i<strs.length;i++) {
		    System.out.println(strs[i]);
		}
	}
	
	//�Զ������ָ��ַ���ʱ:�Զ���(�ո�)(,)���ߺ�(|)���ָ��ַ��� 
	public static  void fun4()
	{
		Pattern pattern = Pattern.compile("[,|]+"); /*+��ʾ�ָ�����������������һ�ηָ�*/
		String[] strs = pattern.split("Java Hello World  Java,Hello,,,,,,,,,World|Sun");
		for (int i=0;i<strs.length;i++) {
		    System.out.println(strs[i]);
		}
	}
	//�������滻���״γ����ַ���
	public static  void  fun5()
	{
		Pattern pattern = Pattern.compile("������ʽ");
		Matcher matcher = pattern.matcher("������ʽ Hello World,������ʽ Hello World");
		//�滻��һ���������������
		System.out.println(matcher.replaceFirst("Java"));
	}
	
	
	//�����滻��ȫ����
	public static  void  fun6()
	{
		Pattern pattern = Pattern.compile("������ʽ");
		Matcher matcher = pattern.matcher("������ʽ Hello World,������ʽ Hello World");
		//�滻��һ���������������
		System.out.println(matcher.replaceAll("88888888888888"));
	}
	
	//�����滻���û��ַ���
	public static  void  fun7()
	{
		Pattern pattern = Pattern.compile("������ʽ");
		Matcher matcher = pattern.matcher("������ʽ Hello World,������ʽ Hello World ");
		StringBuffer sbr = new StringBuffer();
		while (matcher.find()) {
		    matcher.appendReplacement(sbr, "Java");
		}
		matcher.appendTail(sbr);
		System.out.println(sbr.toString());
	}
	
	
	//ȥ��html���
	public static  void  fun8()
	{
	Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
	Matcher matcher = pattern.matcher("<a href=\"index.html\">��ҳ</a>");
	String string = matcher.replaceAll("");
	System.out.println(string);
	}
	
	
	//����html�ж�Ӧ�����ַ���
	public static  void  fun9()
	{
    String str1="href=\"(.+?)\"";  //.+?:��ʾ1�����������ַ����ҿ��Գ��ֶ�Ρ�����������""�š�
	Pattern pattern = Pattern.compile(str1);
	Matcher matcher = pattern.matcher("<a href=\"index.html\">��ҳ</a>");
	if(matcher.find())
	  System.out.println(matcher.group(1));
	}
 
	
	public static void main(String[] args) {
		fun1();
		System.out.println("11111111111111111111111111111111");
		fun2();
		System.out.println("22222222222222222222222222222222");
		fun3();
		System.out.println("33333333333333333333333333333333");
		fun4();
		System.out.println("44444444444444444444444444444444");
		fun5();
		System.out.println("55555555555555555555555555555555");
		fun6();
		System.out.println("66666666666666666666666666666666");
		fun7();
		System.out.println("777777777777777777777777777777777");
		fun8();
		System.out.println("888888888888888888888888888888888");
		fun9();
	}

}
