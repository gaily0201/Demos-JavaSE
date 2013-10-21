package com.msdq.code.mthread;
/**
 * 10��	28�����4���̣߳����������߳�ÿ�ζ�j����1�����������̶߳�jÿ�μ���1
 * @author Administrator
 *
 */
public class ThreadTestFour {
	private int j;

	public static void main(String args[]) {
		ThreadTestFour tt = new ThreadTestFour();
		Inc inc = tt.new Inc();
		Dec dec = tt.new Dec();
		for (int i = 0; i < 2; i++) {
			Thread t = new Thread(inc);
			t.start();
			t = new Thread(dec);
			t.start();
		}
	}

	private synchronized void inc() {
		try{
			Thread.sleep(1000);
			j++;
			System.out.println(Thread.currentThread().getName() + "-inc:" + j);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	private synchronized void dec() {
		try{
			Thread.sleep(1000);
			j--;
			System.out.println(Thread.currentThread().getName() + "-dec:" + j);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	class Inc implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++) {
				inc();
			}
		}
	}

	class Dec implements Runnable {
		public void run() {
			for (int i = 0; i < 100; i++) {
				dec();
			}
		}
	}
}
