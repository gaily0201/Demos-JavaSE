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
		//��̬�����ڵ�һ��ִ��ʱ����ִ�о�̬��ʼ���;�̬��
		//���췽��������Ϊ�Ǿ�̬����
		//ÿ��ʵ��������ִ��һ�ηǾ�̬��ʼ���ͷǾ�̬��
//		new StaticTest();
//		new StaticTest();
	}
}