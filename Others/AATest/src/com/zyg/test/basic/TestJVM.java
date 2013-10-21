package com.zyg.test.basic;

public class TestJVM {
	public static void main(String[] args){
		String result = new TestJVM().getClass().getClassLoader().toString();
		
		System.out.println(result);
		
		try {
			new TestJVM().clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
