package com.zhangyg.thread.mytest;

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
			w.put(i);
			//�������������
			System.out.println("Producer ���� " + i);
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
			//�������������
			System.out.println("Customer "+" ���� "+ w.get());
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
	boolean bFull = false; //�ֿ��Ƿ�����Ʒ
	// ������Ʒ
	public synchronized void put(int value) {
		if (!this.bFull) { // �ֿ���û����Ʒ
			this.value = value;
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
	public synchronized int get() {
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
		return this.value;
	}
}
