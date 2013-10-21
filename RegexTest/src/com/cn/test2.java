package com.cn;

public class test2 {

	public static void main(String[] args) {
//初步认识. * + ?
//.代表的是一个字符    *代表的是0个或多个字符 。+代表的是1个或多个字符。   ?代表的是一个或0个字符
//(.*)表示一个或多个字符.		
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
		
		System.out.println("214523145234532".matches("\\d{3,100}")); /*表示的是一个数字至少三次，不超过100次：也即是3位到100位的数字*/
		System.out.println("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")); /*java中两个反斜杠代表一个反斜杠表示转义*/
		System.out.println("192".matches("[0-2][0-9][0-9]")); /*[中挂号表示范围：第一个数字0到2的范围,第二个数字0到9的范围......]*/
	}

}
