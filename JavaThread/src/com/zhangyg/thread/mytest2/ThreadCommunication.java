package com.zhangyg.thread.mytest2;

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
			this.produce(i);
		}
	}
	
	// ������Ʒ
	public void produce(int value){
		synchronized(w){
			if (!w.isBFull()) { // �ֿ���û����Ʒ
				w.setValue(value);
				System.out.println("Producer:���� " + value);
				w.setBFull(true);
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
			this.consume();
		}
	}
	
	// ������Ʒ
	public void consume(){
		synchronized(w){
			if (!w.isBFull()) { //�ֿ���û����Ʒ
				try {
					w.wait(); //�ȴ�������������Ʒ
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			w.setBFull(false);
			w.notify(); //֪ͨ������������Ʒ
			System.out.println("Customer->���� " + w.getValue());
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
