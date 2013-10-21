package com.zhangyg.thread.mytest;

/**
 * 模拟生产者-消费者关系
 * @author 张燕广
 *
 */
public class ThreadCommunication {
	public static void main(String[] args) {
		Warehouse w = new Warehouse();
		Proudcer p = new Proudcer(w);
		Consumer c = new Consumer(w);
		p.start();
		c.start();
	}
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
		for (int i = 1; i <= 10; i++) {
			// 生产商品
			w.put(i);
			//该语句引起问题
			System.out.println("Producer 生产 " + i);
		}
	}
}

/**
 * 消费者
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
			//该语句引起问题
			System.out.println("Customer "+" 消费 "+ w.get());
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
	boolean bFull = false; //仓库是否有商品
	// 生产商品
	public synchronized void put(int value) {
		if (!this.bFull) { // 仓库中没有商品
			this.value = value;
			this.bFull = true;
			this.notify(); // 通知消费者进行消费
		}
		try {
			this.wait(); // 等待消费者消费商品
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 消费商品
	public synchronized int get() {
		if (!this.bFull) { //仓库中没有商品
			try {
				this.wait(); //等待生产者生产商品
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.bFull = false;
		this.notify(); //通知生产者生产商品
		return this.value;
	}
}
