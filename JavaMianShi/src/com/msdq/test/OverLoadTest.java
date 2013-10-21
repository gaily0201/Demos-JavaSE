package com.msdq.test;

public class OverLoadTest {
	public static void main(String[] args){
		OverLoadTest ot = new OverLoadTest();
		double x=2;
		ot.test(x);
	}
	private void test(int x) {
		System.out.println("int:"+x);
	}

	private void test(char x) {
		System.out.println("char:"+x);
	}
	
	private void test(double x) {
		System.out.println("double:"+x);
	}
}
