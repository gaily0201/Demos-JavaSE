package com.msdq.code.mthread;
/*
 * 11、	28、子线程循环10次，接着主线程循环100
 * ，接着又回到子线程循环10次，接着再回到主线程又循环100
 * ，如此循环50次，请写出程序。 
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
				System.out.println("线程0--------------------");
				for (int i = 1; i < 3; i++) {
					business.SubThread(i);
				}
			}
		}).start();
		
		System.out.println("2222222222222------");
		new Thread(new Runnable() {
			public void run() {
				System.out.println("线程1--------------------");
				for (int i = 1; i < 3; i++) {
					business.MainThread(i);
				}
			}
		}).start();
		
		System.out.println("33333333333333------------");
	}
	
	private class Business {
		boolean bShouldSub = true;//这里相当于定义了控制该谁执行的一个信号灯
		//主线程
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
		
		//子线程
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
