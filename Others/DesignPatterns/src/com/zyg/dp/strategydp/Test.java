package com.zyg.dp.strategydp;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//普通加减乘除的实现
		float a=100;
		float b=25;
		Calc c=new Calc();
		String result=c.oper(a, b, '-');
		System.out.println(result);
	}

}
