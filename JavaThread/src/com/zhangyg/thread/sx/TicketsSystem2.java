package com.zhangyg.thread.sx;

/**
 * 模拟死锁
 * @author Administrator
 *
 */
public class TicketsSystem2 {

	public static void main(String[] args) {
		SellTickets2 st = new SellTickets2();
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

class SellTickets2 implements Runnable {
	int tickets = 100;
	Object obj = new Object(); //同步块需要obj对象
	public boolean flag = false; //验证sell方法的同步使用的是this对象
	public void run() {
		if(flag){
			while(true){
				sell();
			}
		}else{
			while(true){
				synchronized(obj){
					System.out.println("obj********************");
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
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
		}
	}
	
	private synchronized void sell(){
		System.out.println("sell()********************");
		synchronized(obj){
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
}

