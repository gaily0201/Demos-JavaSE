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
	
	// ��ʼ��ʱ������ֱ�ӵ��þ�̬��Ա���Լ�ͬ��ķǾ�̬��Ա

	// ��̬������ʼ��ʱ�������÷Ǿ�̬��Ա
	public static int staticVar = new AssistClass().getNum2();

	public int var = new AssistClass().getNum();
	
	public int var2 = fun3();

	public static void staticFun() {
		// ��̬��������ֱ�ӵ��÷Ǿ�̬��Ա
		// ��Ҫ��1.ʵ���� 2.��Ϊ��̬
		// ! fun2();
		System.out.println("sattic method");

	}

	// ��̬���뾲̬������ʼ��������ͬ�����ȼ�
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
	
	// �Ǿ�̬����Ǿ�̬������ʼ��������ͬ�����ȼ�
	{
		System.out.println("not static block StaticTest");

	}
	
	
	public void fun() {// �Ǿ�̬��������ֱ�ӵ��þ�̬�ͷǾ�̬��Ա
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