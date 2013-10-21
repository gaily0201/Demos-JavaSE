package com.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test10 {

	//查找以Java开头,任意结尾的字符串
	public static  void fun1()
	{
		 Pattern pattern = Pattern.compile("^Java.*");
		  Matcher matcher = pattern.matcher("Java不是人");
		  boolean b= matcher.matches();
		  System.out.println("b=="+b);
	}
	
	
	//以多条件分割字符串时:以逗号(,)或者号(|)来分隔字符串 
	public static  void fun2()
	{
	Pattern pattern = Pattern.compile("[,|]");
	String[] strs = pattern.split("Java Hello World  Java,Hello,   ,World|Sun");
	for (int i=0;i<strs.length;i++) {
	    System.out.println(strs[i]);
	}

	}
	
	//以多条件分割字符串时:以逗号(空格)(,)或者号(|)来分隔字符串 
	public static  void fun3()
	{
		Pattern pattern = Pattern.compile("[ ,|]");
		String[] strs = pattern.split("Java Hello World  Java,Hello,   ,World|Sun");
		for (int i=0;i<strs.length;i++) {
		    System.out.println(strs[i]);
		}
	}
	
	//以多条件分割字符串时:以逗号(空格)(,)或者号(|)来分隔字符串 
	public static  void fun4()
	{
		Pattern pattern = Pattern.compile("[,|]+"); /*+表示分隔符可以连续出现算一次分隔*/
		String[] strs = pattern.split("Java Hello World  Java,Hello,,,,,,,,,World|Sun");
		for (int i=0;i<strs.length;i++) {
		    System.out.println(strs[i]);
		}
	}
	//◆文字替换（首次出现字符）
	public static  void  fun5()
	{
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
		//替换第一个符合正则的数据
		System.out.println(matcher.replaceFirst("Java"));
	}
	
	
	//文字替换（全部）
	public static  void  fun6()
	{
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
		//替换第一个符合正则的数据
		System.out.println(matcher.replaceAll("88888888888888"));
	}
	
	//文字替换（置换字符）
	public static  void  fun7()
	{
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World ");
		StringBuffer sbr = new StringBuffer();
		while (matcher.find()) {
		    matcher.appendReplacement(sbr, "Java");
		}
		matcher.appendTail(sbr);
		System.out.println(sbr.toString());
	}
	
	
	//去除html标记
	public static  void  fun8()
	{
	Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
	Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
	String string = matcher.replaceAll("");
	System.out.println(string);
	}
	
	
	//查找html中对应条件字符串
	public static  void  fun9()
	{
    String str1="href=\"(.+?)\"";  //.+?:表示1个以上任意字符并且可以出现多次。并且外面有""号。
	Pattern pattern = Pattern.compile(str1);
	Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
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
