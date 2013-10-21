package com.zhangyg.thread.sx;

/**
 * ģ������
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
	Object obj = new Object(); //ͬ������Ҫobj����
	public boolean flag = false; //��֤sell������ͬ��ʹ�õ���this����
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

