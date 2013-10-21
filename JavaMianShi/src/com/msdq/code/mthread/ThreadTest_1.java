package com.msdq.code.mthread;
/*
 * 11��	28�����߳�ѭ��10�Σ��������߳�ѭ��100
 * �������ֻص����߳�ѭ��10�Σ������ٻص����߳���ѭ��100
 * �����ѭ��50�Σ���д������ 
 */
public class ThreadTest_1 {
	public static void main(String[] args) {
		new ThreadTest_1().init();
	}

	public void init() {
		final Business business = new Business();
		System.out.println("11111111111------");
		new Thread(new Runnable() {
			public void run() {
				System.out.println("�߳�0--------------------");
				for (int i = 1; i < 3; i++) {
					business.SubThread(i);
				}
			}
		}).start();
		
		System.out.println("2222222222222------");
		new Thread(new Runnable() {
			public void run() {
				System.out.println("�߳�1--------------------");
				for (int i = 1; i < 3; i++) {
					business.MainThread(i);
				}
			}
		}).start();
		
		System.out.println("33333333333333------------");
	}
	
	private class Business {
		boolean bShouldSub = true;//�����൱�ڶ����˿��Ƹ�˭ִ�е�һ���źŵ�
		//���߳�
		public synchronized void MainThread(int i) {
			if (bShouldSub){
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int j = 0; j < 5; j++) {
				try {
					Thread.sleep(200);
					System.out.println(Thread.currentThread().getName() + ":i=" + i
							+ ",j=" + j);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			bShouldSub = true;
			this.notify();
		}
		
		//���߳�
		public synchronized void SubThread(int i) {
			if (!bShouldSub){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			for (int j = 0; j < 10; j++) {
				try {
					Thread.sleep(200);
					System.out.println(Thread.currentThread().getName() + ":i=" + i
							+ ",j=" + j);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bShouldSub = false;
			this.notify();
		}
	}
}
