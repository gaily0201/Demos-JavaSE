package com.msdq.code.mthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*9、	简述synchronized和java.util.concurrent.locks.Lock的异同 ？ 
主要相同点：Lock能完成synchronized所实现的所有功能 
主要不同点：Lock有比synchronized更精确的线程语义和更好的性能。synchronized会自动释放锁，而Lock一定要求程序员手工释放，并且必须在finally从句中释放。Lock还有更强大的功能，例如，它的tryLock方法可以非阻塞方式去拿锁。 
举例说明（对下面的题用lock进行了改写）：
 */
public class ThreadTest1 {
	private int j = 0;
	private Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		ThreadTest1 tt = new ThreadTest1();

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
				/*synchronized (ThreadTest.this) {
				System.out.println("j++=" + j++);	
				}*/
				lock.lock();
				try {
					Thread.sleep(1000);
					System.out.println("j++=" + j++);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				} finally {
					lock.unlock();
				}
			}
		}
	}

	private class Subtractor implements Runnable {
		@Override
		public void run() {
			while (true) {
				/*synchronized (ThreadTest.this) {			
					System.out.println("j--=" + j--);
					//这里抛异常了，锁能释放吗？
				}*/
				lock.lock();
				try {
					Thread.sleep(1000);
					System.out.println("j--=" + j--);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				} finally {
					lock.unlock();
				}
			}
		}

	}
}
