package com.zyg.statics.test;

public class StaticTest extends fatherClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// staticFun();
		// System.out.println(st.var+"&"+st.var2+"&"+staticVar);

		// StaticTest st;
		
		System.out.println("------------------");
		
		System.out.println("--StaticTest->main");
		StaticTest st = new StaticTest();
		
		System.out.println("------------------");
	}
	
	public StaticTest() {
		System.out.println("StaticTest constructor");
	}
	
	// 初始化时，可以直接调用静态成员，以及同类的非静态成员

	// 静态变量初始化时不能引用非静态成员
	public static int staticVar = new AssistClass().getNum2();

	public int var = new AssistClass().getNum();
	
	public int var2 = fun3();

	public static void staticFun() {
		// 静态方法不能直接调用非静态成员
		// 需要：1.实例化 2.改为静态
		// ! fun2();
		System.out.println("sattic method");

	}

	// 静态域与静态变量初始化具有相同的优先级
	static {
		staticVar++;
		System.out.println("static block:"+staticVar);

	}
	
	public static int staticFun2() {
		System.out.println("static field init staticFun2");
		return 2;
	}
	
	
	public static int staticFun3() {
		System.out.println("not static field init staticFun3");
		return 3;
	}
	
	// 非静态域与非静态变量初始化具有相同的优先级
	{
		System.out.println("not static block StaticTest");

	}
	
	
	public void fun() {// 非静态方法可以直接调用静态和非静态成员
		staticVar = 1;
		staticFun();
		fun2();
	}

	public void fun2() {

	}

	public int fun3() {
		return 3;
	}
}