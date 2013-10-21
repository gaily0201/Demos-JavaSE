package com.zyg.statics.test;

public class AssistClass {
	int i = 1;

	public int getNum() {
		System.out.println("not static field init getNum");
		return 4;
	}

	public int getNum2() {
		System.out.println("static field init getNum2");
		return 5;
	}

	public int getNum3() {
		System.out.println("father static field init");
		return 5;
	}

	public int getNum4() {
		System.out.println("father not static field init");
		return 5;
	}

	public static void main(String[] args) {
		//静态方法在第一次执行时会先执行静态初始化和静态域
		//构造方法可以认为是静态方法
		//每次实例化都会执行一次非静态初始化和非静态域
//		new StaticTest();
//		new StaticTest();
	}
}