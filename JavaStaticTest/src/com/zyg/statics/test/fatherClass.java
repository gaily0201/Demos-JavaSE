package com.zyg.statics.test;
public class fatherClass{
	
	//ͬ��̬ʱ������ı�����ʼ��/����������ִ��
	static int fatherVar=new AssistClass().getNum3();
	
	static{
		System.out.println("father static block");
	}
	
	//ͬ�Ǿ�̬ʱ������ı�����ʼ��/����������ִ��
	{
		System.out.println("father not static block");
	}
	
	int fatherVar2=new AssistClass().getNum4();
}