package com.zhangyg.thread.mytest3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟生产者-消费者关系
 * @author 张燕广
 *
 */
public class ThreadCommunication {
	private Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		ThreadCommunication tc = new ThreadCommunication();
		Warehouse w = tc.new Warehouse();
		Proudcer p = tc.new Proudcer(w);
		Consumer c = tc.new Consumer(w);
		p.start();
		c.start();
	}

	/**
	 * 生产者
	 * @author 张燕广
	 *
	 */
	class Proudcer extends Thread {
		Warehouse w;

		Proudcer(Warehouse w) {
			this.w = w;
		}

		@Override
		public void run() {
			while (true) {
				// 生产商品
				this.produce(w.getValue()+1);
			}
		}

		// 生产商品
		public void produce(int value) {
			lock.lock();
			try {
				Thread.sleep(100);
				if (!w.isBFull()) { // 仓库中没有商品
					w.setValue(value);
					System.out.println("Producer:生产 " + value);
					w.setBFull(true);
				}
			} catch(InterruptedException e ){
				System.out.println(e.getMessage());
			}
			finally {
				lock.unlock();
			}
		}
	}

	/**
	 * 消费者
	 * 
	 * @author 张燕广
	 * 
	 */
	class Consumer extends Thread {
		Warehouse w;

		Consumer(Warehouse w) {
			this.w = w;
		}

		@Override
		public void run() {
			while (true) {
				this.consume();
			}
		}

		// 消费商品
		public void consume() {
			lock.lock();
			try {
				Thread.sleep(100);
				if (w.isBFull()) { // 仓库有商品
					w.setBFull(false);
					System.out.println("Customer->消费 " + w.getValue());
				}
			} catch(InterruptedException e ){
				System.out.println(e.getMessage());
			}
			finally {
				lock.unlock();
			}
		}
	}

	/**
	 * 仓库
	 * @author 张燕广
	 *
	 */
	class Warehouse {
		private int value;
		private boolean bFull = false; //仓库是否有商品

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public boolean isBFull() {
			return bFull;
		}

		public void setBFull(boolean full) {
			bFull = full;
		}
	}
}
