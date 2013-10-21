package com.msdq.nested;

public class MyOuter {
	Thread t = new Thread();
	public void startTest(){
		t.start();
	}
	
	//使用匿名内部类
	public void start(){
		new Thread(
			new Runnable(){
				public void run(){}
			}
		);
	}
}
