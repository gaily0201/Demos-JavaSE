package com.zhangyg.thread.sx;

/**
 * �ʼǣ�
 * ͬ�������ַ�����ͬ�����ͬ������
 * ÿ��������һ��������������
 * ͬ���������õ���this������Ķ��������
 * ÿ��classҲ��һ�����������class����Ӧ��class���������
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
	Object obj = new Object(); //ͬ������Ҫobj����
	public boolean flag = false; //��֤sell������ͬ��ʹ�õ���this����
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
			//ͬ�������
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

