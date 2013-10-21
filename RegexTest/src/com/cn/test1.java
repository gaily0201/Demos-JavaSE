package com.cn;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {


	public static void main(String[] args) {
		System.out.println("abc".matches("..."));
		System.out.println("a88887tt02y444k4a".replaceAll("\\d", "-")); /* d代表的是一个数字： java中两个反斜杠代表一个反斜杠表示转义*/
		


		
		Pattern p = Pattern.compile("[a-z]{3}");/*Pattern是编译好的匹配模式：匹配的是3个字符的字符串，并且每个字符都是从：a-z的里面的字母*/
		Matcher m = p.matcher("fgh"); /*Matcher：是匹配器：匹配字符串*/
		System.out.println("m.matches()===="+m.matches());/*matches:表示是匹配还是不匹配*/
		
		
		System.out.println("fga".matches("[a-z]{3}")); /*等价上面的三句话*/
		
		
		
		
		
		
		
	}

}
