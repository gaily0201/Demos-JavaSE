package com.cn;

public class test3 {

	public static void main(String[] args) {
		//范围[]:一个中挂号表示匹配一个字符
		System.out.println("a".matches("[abc]")); /*是否匹配abc中的任何一个*/
		System.out.println("a".matches("[^abc]"));/*^abc表式除了abc的其他字符*/
		System.out.println("111111111111111111111111111111111111111111111111");
		
		System.out.println("A".matches("[a-zA-Z]")); /*匹配小写的a到z或者是大写的A到Z*/
		System.out.println("A".matches("[a-z]|[A-Z]"));/*与上面的一样的*/
		System.out.println("2222222222222222222222222222222222222222222222222");
		
		System.out.println("A".matches("[a-z[A-Z]]"));/*与上面的一样的意思。写法不同而已*/
		System.out.println("R".matches("[A-Z&&[RFG]]")); /*表示A到Z并且是RFG中三者之一的*/
		

	}

}
