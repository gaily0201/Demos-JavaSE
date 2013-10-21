package com.msdq.test;

public class ReturnTest {

	/**
	 * @param args add by zxx ,Dec 9, 2008
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReturnTest().test());
	}

	static int test() {
		int x = 1;
		try {
			return x;
		} finally {
			System.out.println("finally");
			x=x+1;
		}
	}

}
