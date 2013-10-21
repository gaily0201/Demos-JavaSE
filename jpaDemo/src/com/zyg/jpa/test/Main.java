package com.zyg.jpa.test;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestBean tb = new TestBean("abcd");
		//System.out.println(tb);
		
		Parse p = new Parse();
		
		p.parse(tb, "toString");
	}

}
