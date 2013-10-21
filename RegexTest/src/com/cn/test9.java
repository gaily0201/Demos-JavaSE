package com.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test9 {
	/*�������*/
	public static void fun1()
    {
    	Pattern p = Pattern.compile(".{3,10}[0-9]"); /*3��10���ַ��������һλ����:û���ʺţ�һ�γ�10���ַ����ֲ�ƥ�������³�һ���ַ���ȥƥ��......*/
		String s = "aaaa5bbbb6";
		Matcher m = p.matcher(s);
		if(m.find())
			System.out.println(m.start() + "-" + m.end());
		else 
			System.out.println("not match!");
    }
	
	
	
	/*��ǿģʽ*/
    public static void fun2()
    {
    	Pattern p = Pattern.compile(".{3,10}?[0-9]"); /*��һ�γ�3���ַ������ϲ�����ʱ���ĸ���ʾ���ӣ���˲����ϣ��ٳԽ�һλ����ʱ����*/
		String s = "aaaa5bbbb68";
		Matcher m = p.matcher(s);
		if(m.find())
			System.out.println(m.start() + "-" + m.end());
		else 
			System.out.println("not match!");
    }
    
    /*һ�㲻��:ռ��ģʽ*/
    public static void fun3()
    {
    	Pattern p = Pattern.compile(".{3,10}+[0-9]");/*һ�γ�10���ַ����Ҳ�������*/
		String s = "aaaa5bbbb6";
		Matcher m = p.matcher(s);
		if(m.find())
			System.out.println(m.start() + "-" + m.end());
		else 
			System.out.println("not match!");
    }
    
    public static void fun4()
    {
    	Pattern p = Pattern.compile(".{3}"); 
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    	
    }
    
    public static void fun5()
    {
    	Pattern p = Pattern.compile(".{3}(?=a)"); /*(?=a)����ʾ�ǲ�����(������a)����ʾ�������ַ���a*/
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    	
    }
	
    
    public static void fun6()
    {
    	Pattern p = Pattern.compile("(?=a).{3}"); /*(?=a)����ʾ�ǲ�����(������a)����ʾ��a��ͷ���������ַ�,����a*/
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    	
    }
    public static void fun7()
    {
    	Pattern p = Pattern.compile(".{3}(?=!a)"); 
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    	
    }
    
    
    public static void fun8()
    {
    	Pattern p = Pattern.compile(".{3}(?<=a)"); /*�Ӻ���ǰ��������a��*/
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    }
    
    /*��ǰ����*/
    public static void fun9()
    {
    	Pattern p = Pattern.compile("(\\d\\d)\\1");/*1:��ʾ�����ҵ��Ľ�������ǰ���ҵ���һģһ��*/
		String s = "1212";
		Matcher m = p.matcher(s);
		System.out.println(m.matches());		
    }
    /*��ǰ����*/
    public static void fun10()
    {
    	Pattern p = Pattern.compile("(\\d(\\d))\\2");/*(\\d(\\d)):�����������飺�ڶ�����ץ������2 �����\\2:��ʾ�����Ҫ�͵ڶ���ץ������һ��*/
		String s = "122";
		Matcher m = p.matcher(s);
		System.out.println(m.matches());	
    }
    
    public  static void fun11()
    {
    	Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
    	
    	System.out.println("Java".matches("(?i)(java)")); /*(?i)�ǲ�����:������ļ�д*/
    	
    }
    
	public static void main(String[] args) {
		 System.out.println("==================fun1();================================");
		 fun1();
		 System.out.println("==================fun2();================================");
		 fun2();
		 System.out.println("==================fun3();================================");
		 fun3();
		 System.out.println("==================fun4();================================");
		 fun4();
		 System.out.println("==================fun5();================================");
		 fun5();
		 System.out.println("==================fun6();================================");
		 fun6();
		 System.out.println("==================fun7();================================");
		 fun7();
		 System.out.println("==================fun8();================================");
		 fun8();
		 System.out.println("==================fun9();================================");
		 fun9();
		 System.out.println("==================fun10();================================");
		 fun10();
		 System.out.println("==================fun11();================================");
		 fun11();
	}

}
/*
��ʹ��Pattern.compile����ʱ�����Լ������������ʽ��ƥ����Ϊ�Ĳ�����
Pattern Pattern.compile(String regex, int flag) 

flag��ȡֵ��Χ���£�
Pattern.CANON_EQ     ���ҽ��������ַ���"����ֽ�(canonical decomposition)"����ȫ��ͬ������£����϶�ƥ�䡣�������������־֮�󣬱��ʽ"a\u030A"��ƥ��"?"��Ĭ������£�������"�淶�����(canonical equivalence)"��
Pattern.CASE_INSENSITIVE(?i)     Ĭ������£���Сд�����е�ƥ��ֻ������US-ASCII�ַ����������־���ñ��ʽ���Դ�Сд����ƥ�䡣Ҫ���Unicode�ַ����д�С�����е�ƥ�䣬ֻҪ��UNICODE_CASE�������־�����������ˡ�
Pattern.COMMENTS(?x)     ������ģʽ�£�ƥ��ʱ�����(������ʽ���)�ո��ַ�(����ע������ָ���ʽ���"\\s"������ָ���ʽ��Ŀո�tab���س�֮��)��ע�ʹ�#��ʼ��һֱ�����н���������ͨ��Ƕ��ʽ�ı�־������Unix��ģʽ��
Pattern.DOTALL(?s)     ������ģʽ�£����ʽ''.''����ƥ�������ַ���������ʾһ�еĽ�������Ĭ������£����ʽ''.''��ƥ���еĽ�������
Pattern.MULTILINE
(?m)     ������ģʽ�£�''^''��''$''�ֱ�ƥ��һ�еĿ�ʼ�ͽ��������⣬''^''��Ȼƥ���ַ����Ŀ�ʼ��''$''Ҳƥ���ַ����Ľ�����Ĭ������£����������ʽ����ƥ���ַ����Ŀ�ʼ�ͽ�����
Pattern.UNICODE_CASE
(?u)     �����ģʽ�£�����㻹������CASE_INSENSITIVE��־����ô�����Unicode�ַ����д�Сд�����е�ƥ�䡣Ĭ������£���Сд�����е�ƥ��ֻ������US-ASCII�ַ�����
Pattern.UNIX_LINES(?d)     �����ģʽ�£�ֻ��''\n''�ű�����һ�е���ֹ��������''.''��''^''���Լ�''$''����ƥ�䡣 
*/