package com.msdq.nested;

public class Outer {
	int out = 0;
	
	public void method(){
		Inner1 inner = new Inner1();
		final int temp = 0;
		class Inner2{//�ڷ������ڲ�������ڲ���
			
			public void test(){
				System.out.println(temp); //temp������final���Ͳſ��Է���
			}
		}
	}
	
	public class Inner1{ //�������ⶨ���ڲ���
		
	}
}
