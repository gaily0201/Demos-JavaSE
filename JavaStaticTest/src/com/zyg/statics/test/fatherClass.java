package com.zyg.statics.test;
public class fatherClass{
	
	//同静态时，父类的变量初始化/域先于子类执行
	static int fatherVar=new AssistClass().getNum3();
	
	static{
		System.out.println("father static block");
	}
	
	//同非静态时，父类的变量初始化/域先于子类执行
	{
		System.out.println("father not static block");
	}
	
	int fatherVar2=new AssistClass().getNum4();
}