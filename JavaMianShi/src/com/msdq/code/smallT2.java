package com.msdq.code;

public class smallT2 {
	public static void main(String[] args) {
		System.out.println(new smallT2().test());
	}
	
	int test() {
		try {
			return func1();
		} finally {
			return func2();
		}
	}

	int func1() {
		System.out.println("func1");
		return 1;
	}

	int func2() {
		System.out.println("func2");
		return 2;
	}
}
