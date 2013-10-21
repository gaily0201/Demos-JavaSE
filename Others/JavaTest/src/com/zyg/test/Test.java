package com.zyg.java.test;

public class Test {
	private static boolean run = true;

	public void update() {
		for (int i = 0; i < 10; i++) {
			if (run) {
				System.out.println(i);
				return;
			}
			System.out.println("Hello:" + i);
		}
		System.out.println("end");
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.update();
	}
}
