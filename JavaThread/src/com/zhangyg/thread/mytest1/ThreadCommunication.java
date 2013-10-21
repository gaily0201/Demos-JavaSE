package com.zhangyg.thread.mytest1;

/**
 * ģ��������-�����߹�ϵ
 * @author �����
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
		for (int i = 1; i <= 10; i++) {
			// ������Ʒ
			w.produce(i);
		}
	}
}

/**
 * ������
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
			w.consume();
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
	// ������Ʒ
	public synchronized void produce(int newValue) {
		if (!this.bFull) { // �ֿ���û����Ʒ
			this.value = newValue;
			System.out.println("Producer:���� " + newValue);
			this.bFull = true;
			this.notify(); // ֪ͨ�����߽�������
		}
		try {
			this.wait(); // �ȴ�������������Ʒ
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ������Ʒ
	public synchronized void consume() {
		if (!this.bFull) { //�ֿ���û����Ʒ
			try {
				this.wait(); //�ȴ�������������Ʒ
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.bFull = false;
		this.notify(); //֪ͨ������������Ʒ
		System.out.println("Customer->���� " + this.value);
	}
}
