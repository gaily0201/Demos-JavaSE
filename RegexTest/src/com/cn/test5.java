package com.cn;

public class test5 {

	public static void main(String[] args) {
		//unix：的一套标准      . 代表任意字符
		
		//边界匹配：
		System.out.println("hello sir".matches("^h.*")); /*^代表一行的开头：以h开头.代表的是任何字符。*代表的是0个或多个字符*/
		System.out.println("hello sir".matches(".*"));
		System.out.println("hello sir".matches(".*ir$"));
		System.out.println("sir".matches(".*ir$")); 
		System.out.println("111111111111111111111111111111111111111111111111");
		
		
		System.out.println("hello sir".matches("^h[a-z]{1,3}o\\b.*")); /*\\b:表示单词边界：这里就是一个单词的空格*/
		System.out.println("hellosir".matches("^h[a-z]{1,3}o\\b.*"));
		System.out.println("2222222222222222222222222222222222222222222222222");
		
		//空白行：
		System.out.println(" \n".matches("^[\\s&&[^\\n]]*\\n$")); /*\\s:表示开始的是一个空白字符。&&[^\\n]]表示：并且该空白字符不是换行符。$表示已经是行的末尾了*/
		System.out.println("aaa 8888c".matches(".*\\d{4}."));
		System.out.println("3333333333333333333333333333333333333333333333333");
		
		
		
		System.out.println("aaa 8888".matches(".*\\b\\d{3}.")); /*(.*)表示一个或多个字符*/
		System.out.println("aaa8888c".matches(".*\\d{4}."));
		System.out.println("4444444444444444444444444444444444444444444444444");
		
		System.out.println("aaa8888c".matches(".*\\b\\d{4}."));
		

	}

}
