package com.mianshi.overrideload;

public class TestOverload {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestOverload t = new TestOverload();
		
		double d = 2;
		
		t.test(d);
	}
	
	public void test(char c){
		System.out.println("char:"+c);
	}
	
	public void test(int x){
		System.out.println("int:"+x);
	}
	
	public void test(double d){
		System.out.println("double:"+d);
	}
}
