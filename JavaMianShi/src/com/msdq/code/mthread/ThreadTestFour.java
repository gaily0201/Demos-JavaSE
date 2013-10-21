package com.msdq.code.mthread;
/**
 * 10、	28、设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1
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
