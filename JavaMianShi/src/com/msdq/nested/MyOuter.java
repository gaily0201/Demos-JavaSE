package com.msdq.nested;

public class MyOuter {
	Thread t = new Thread();
	public void startTest(){
		t.start();
	}
	
	//ʹ�������ڲ���
	public void start(){
		new Thread(
			new Runnable(){
				public void run(){}
			}
		);
	}
}
