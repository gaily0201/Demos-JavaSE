package com.zyg.dp.strategydp;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��ͨ�Ӽ��˳���ʵ��
		float a=100;
		float b=25;
		Calc c=new Calc();
		String result=c.oper(a, b, '-');
		System.out.println(result);
	}

}
