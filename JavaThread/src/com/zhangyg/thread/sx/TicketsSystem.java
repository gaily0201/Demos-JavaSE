package com.zhangyg.thread.sx;

/**
 * 笔记：
 * 同步的两种方法：同步块和同步方法
 * 每个对象都有一个监视器（锁）
 * 同步方法利用的是this所代表的对象的锁。
 * 每个class也有一个锁，是这个class所对应的class对象的锁。
 * @author Administrator
 *
 */
public class TicketsSystem {

	public static void main(String[] args) {
		SellTickets st = new SellTickets();
		new Thread(st).start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st.flag = true;
		new Thread(st).start();
		//new Thread(st).start();
		//new Thread(st).start();
	}

}

class SellTickets implements Runnable {
	int tickets = 100;
	Object obj = new Object(); //同步块需要obj对象
	public boolean flag = false; //验证sell方法的同步使用的是this对象
	public void run() {
		if(!flag){
			while(true){
				sell();
			}
		}else{
			while(true){
				//synchronized(obj){
				synchronized(this){
					if (tickets > 0){
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("obj:"+Thread.currentThread().getName()
								+ " sell tickets:" + tickets);
						tickets--;
					}
				}
			}
		}
		
		/*while(true){
			//同步代码块
			synchronized(obj){
				if (tickets > 0){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ " sell tickets:" + tickets);
					tickets--;
				}
			}
			sell();
		}*/
	}
	
	private synchronized void sell(){
		if (tickets > 0){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("sell():"+Thread.currentThread().getName()
					+ " sell tickets:" + tickets);
			tickets--;
		}
	}
}

