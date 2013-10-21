package com.zyg.classy;

public class Confusing {
	private Confusing(Object o) {
		System.out.println("Object");
	}

	private Confusing(String str) {
		System.out.println("String");
	}

	public static void main(String[] args) {
		new Confusing(null);
	}
}
