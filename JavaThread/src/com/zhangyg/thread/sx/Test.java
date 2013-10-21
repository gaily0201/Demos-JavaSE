package com.zhangyg.thread.sx;

/**
 * ģ��������-�����߹�ϵ
 * @author �����
 *
 */
public class Test {
	public static void main(String[] args) {
		Warehouse w = new Warehouse();
		Proudcer p = new Proudcer(w);
		Customer c = new Customer(w);
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
		for (int i = 1; i <= 5; i++) {
			// ������Ʒ
			w.put(i);
			//���εĴ���
			//System.out.println("Producer ���� " + i);
		}
	}
}

/**
 * ������
 * @author �����
 *
 */
class Customer extends Thread {
	Warehouse w;

	Customer(Warehouse w) {
		this.w = w;
	}

	@Override
	public void run() {
		while (true) {
			//���εĴ���
			//System.out.println("Customer "+" ���� "+ w.get());
			w.get();
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
			System.out.println("Producer ���� " + value);
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
		System.out.println("Customer "+" ���� "+ this.value);
		return this.value;
	}
}
