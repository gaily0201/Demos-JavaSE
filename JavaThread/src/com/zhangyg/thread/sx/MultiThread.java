package com.zhangyg.thread.sx;

public class MultiThread {

	public static void main(String[] args) {
		MyThread mt = new MyThread();
		//mt.setPriority(Thread.MAX_PRIORITY);
		//mt.setDaemon(true);
		//mt.start();
		
		/*new Thread(mt,"zhangyg-thread").start();
		new Thread(mt,"zhangyg-thread").start();
		new Thread(mt,"zhangyg-thread").start();
		new Thread(mt,"zhangyg-thread").start();*/
		
		MyThread2 mt2 = new MyThread2();
		mt2.getThread().start();
		mt2.getThread().start();
		mt2.getThread().start();
		mt2.getThread().start();
		
		int index = 0;
		while (true) {
			/*if(index++==1000){
				break;
			}*/
			System.out.println("main:" + Thread.currentThread().getName());
		}

		/*MyThread mt2 = new MyThread();
		mt2.start();*/
	}
}

class MyThread /*extends Thread*/ implements Runnable {
	int n = 0;
	public void run() {
		while (true) {
			//System.out.println(this.getName());
			System.out.println(Thread.currentThread().getName()+"->n:"+n++);
			//yield();
		}
		
	}
}

class MyThread2{
	int n = 0;
	private class InnerThread extends Thread{
		
		public void run() {
			while (true) {
				System.out.println(Thread.currentThread().getName()+"->n:"+n++);
			}
		}
	}
	
	public Thread getThread(){
		return new InnerThread();
	}
}
