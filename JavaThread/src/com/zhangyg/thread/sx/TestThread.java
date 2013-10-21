package com.zhangyg.thread.sx;

/**
 * 测试线程终止
 * @author Administrator
 *
 */
public class TestThread {
	public static void main(String[] args) {
		Thread1 t = new Thread1();
		t.start();
		int index = 1;
		while(true){
			if(index++==500){
				t.stopThread();
				t.interrupt(); //中断线程
				break;
			}
			System.out.println(Thread.currentThread().getName()+index);
		}
	}
}

class Thread1 extends Thread{
	boolean bStop = false;
	
	public void stopThread(){
		bStop = true;
	}
	
	@Override
	public synchronized void run() {
		while(!bStop){
			try {
				wait();
			} catch (InterruptedException e) {
				if(!bStop){
					return;
				}
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
}
