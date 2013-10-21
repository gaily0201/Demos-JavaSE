package com.zyg.puzzels.Expressive;

public class BanjinBaliang {
	public static void main(String[] args) {
	   /*
	    short x = 0;
		int i = 123456;
		x += i; // 包含了一个隐藏的转型！
		System.out.println(x);
		//x = x + i; // 不要编译——“可能会丢掉精度”  
		
		*/
		Object x = "Buy ";
		String i = "Effective Java!";
		x = x + i;
		System.out.println(x);
		//x += i;
	}
}
