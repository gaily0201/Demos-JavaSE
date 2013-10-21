package com.msdq.code.mthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest2 {
	private int j = 0;
	private Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		ThreadTest2 tt = new ThreadTest2();

		new Thread(tt.new Adder()).start();
		new Thread(tt.new Subtractor()).start();
		/*for (int i = 0; i < 2; i++) {
			new Thread(tt.new Adder()).start();
			new Thread(tt.new Subtractor()).start();
		}*/
	}

	private class Adder implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (ThreadTest2.this) {
					try {
						Thread.sleep(1000);
						System.out.println("j++=" + j++);	
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				/*lock.lock();
				try {
					Thread.sleep(1000);
					System.out.println("j++=" + j++);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				} finally {
					lock.unlock();
				}*/
			}
		}
	}

	private class Subtractor implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (ThreadTest2.this) {	
					try {
						Thread.sleep(1000);
						System.out.println("j--=" + j--);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//这里抛异常了，锁能释放吗？
				}
				/*lock.lock();
				try {
					Thread.sleep(1000);
					System.out.println("j--=" + j--);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				} finally {
					lock.unlock();
				}*/
			}
		}

	}
}
