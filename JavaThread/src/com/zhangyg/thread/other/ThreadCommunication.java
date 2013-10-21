package com.zhangyg.thread.other;

/**
 * ģ��������-�����߹�ϵ
 * 
 * @author �����
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
 * ������
 * 
 * @author �����
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
				if (!w.bFull) { // �ֿ���û����Ʒ
					w.value = i;
					
					System.out.println("Producer ���� " + i);
					w.bFull = true;
					w.notify(); // ֪ͨ�����߽�������
				}
				try {
					w.wait(); // �ȴ�������������Ʒ
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

/**
 * ������
 * 
 * @author �����
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
				if (!w.bFull) { // �ֿ���û����Ʒ
					try {
						w.wait(); // �ȴ�������������Ʒ
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				w.bFull = false;
				w.notify(); // ֪ͨ������������Ʒ
				System.out.println("Customer " + " ���� " + w.value);
			}
		}
	}
}

/**
 * �ֿ�
 * 
 * @author �����
 * 
 */
class Warehouse {
	public int value;
	public boolean bFull = false; // �ֿ��Ƿ�����Ʒ
}
