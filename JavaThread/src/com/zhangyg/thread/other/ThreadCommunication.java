package com.zhangyg.thread.other;

/**
 * 模拟生产者-消费者关系
 * 
 * @author 张燕广
 * 
 */
public class ThreadCommunication {
	public static void main(String[] args) {
		Warehouse w = new Warehouse();
		
		 Proudcer p = new Proudcer(w); Customer c = new Customer(w);
		 p.start(); 
		 c.start();
		 
		/*new Thread(new Proudcer(w)).start();
		new Thread(new Customer(w)).start();*/
	}
}

/**
 * 生产者
 * 
 * @author 张燕广
 * 
 */
class Proudcer extends Thread {
	Warehouse w;

	Proudcer(Warehouse w) {
		this.w = w;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			synchronized (w) {
				if (!w.bFull) { // 仓库中没有商品
					w.value = i;
					
					System.out.println("Producer 生产 " + i);
					w.bFull = true;
					w.notify(); // 通知消费者进行消费
				}
				try {
					w.wait(); // 等待消费者消费商品
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

/**
 * 消费者
 * 
 * @author 张燕广
 * 
 */
class Customer extends Thread {
	Warehouse w;

	Customer(Warehouse w) {
		this.w = w;
	}

	public void run() {
		while (true) {
			synchronized (w) {
				if (!w.bFull) { // 仓库中没有商品
					try {
						w.wait(); // 等待生产者生产商品
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				w.bFull = false;
				w.notify(); // 通知生产者生产商品
				System.out.println("Customer " + " 消费 " + w.value);
			}
		}
	}
}

/**
 * 仓库
 * 
 * @author 张燕广
 * 
 */
class Warehouse {
	public int value;
	public boolean bFull = false; // 仓库是否有商品
}
