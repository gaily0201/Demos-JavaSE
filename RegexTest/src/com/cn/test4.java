package com.cn;

public class test4 {

	public static void main(String[] args) {
		// \s:匹配任何空白字符，包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效
		// \w：匹配任何字类字符，包括下划线。与[A-Za-z0-9_]等效。

		System.out.println(" \n\r\t".matches("\\s{4}"));
		System.out.println(" ".matches("\\S")); //大S表示非空白字符
		System.out.println("111111111111111111111111111111111111111111111111");
		
		
		System.out.println("a_8".matches("\\w{3}"));
		System.out.println("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));//[&^#%]+ 表示挂号里面的四者之一出现一次或多次
		System.out.println("2222222222222222222222222222222222222222222222222");
		
		System.out.println("\\".matches("\\\\")); /*java里面两个\代表一个\ :正则表达式也是两个\代表一个\*/

	}

}
