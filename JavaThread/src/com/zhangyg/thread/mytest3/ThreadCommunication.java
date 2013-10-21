package com.zhangyg.thread.mytest3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ģ��������-�����߹�ϵ
 * @author �����
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
	 * ������
	 * @author �����
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
				// ������Ʒ
				this.produce(w.getValue()+1);
			}
		}

		// ������Ʒ
		public void produce(int value) {
			lock.lock();
			try {
				Thread.sleep(100);
				if (!w.isBFull()) { // �ֿ���û����Ʒ
					w.setValue(value);
					System.out.println("Producer:���� " + value);
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
	 * ������
	 * 
	 * @author �����
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

		// ������Ʒ
		public void consume() {
			lock.lock();
			try {
				Thread.sleep(100);
				if (w.isBFull()) { // �ֿ�����Ʒ
					w.setBFull(false);
					System.out.println("Customer->���� " + w.getValue());
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
	 * �ֿ�
	 * @author �����
	 *
	 */
	class Warehouse {
		private int value;
		private boolean bFull = false; //�ֿ��Ƿ�����Ʒ

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
