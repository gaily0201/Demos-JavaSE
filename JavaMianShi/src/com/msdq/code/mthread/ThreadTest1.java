package com.msdq.code.mthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*9��	����synchronized��java.util.concurrent.locks.Lock����ͬ �� 
��Ҫ��ͬ�㣺Lock�����synchronized��ʵ�ֵ����й��� 
��Ҫ��ͬ�㣺Lock�б�synchronized����ȷ���߳�����͸��õ����ܡ�synchronized���Զ��ͷ�������Lockһ��Ҫ�����Ա�ֹ��ͷţ����ұ�����finally�Ӿ����ͷš�Lock���и�ǿ��Ĺ��ܣ����磬����tryLock�������Է�������ʽȥ������ 
����˵���������������lock�����˸�д����
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
					//�������쳣�ˣ������ͷ���
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
