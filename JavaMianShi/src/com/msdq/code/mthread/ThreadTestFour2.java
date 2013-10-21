package com.msdq.code.mthread;
/**
 * 10��	28�����4���̣߳����������߳�ÿ�ζ�j����1�����������̶߳�jÿ�μ���1
 * @author Administrator
 *
 */
public class ThreadTestFour2 {
	JManager jm = new JManager();
	public static void main(String[] args){
		ThreadTestFour2 ttf = new ThreadTestFour2();
		ttf.call();
	}
	
	private void call(){
		for(int i=0;i<2;i++){
			new Thread(
				new Runnable(){
					public void run() {
						while(true){
							jm.add();
						}
					}
				}
			).start();
			
			new Thread(
					new Runnable(){
						public void run() {
							while(true){
								jm.sub();
							}
						}
					}
				).start();
		}
	}
}

class JManager{
	private int j=0;
	
	public synchronized void add(){
		try{
			Thread.sleep(500);
			j++;
			System.out.println("++ ��"+j+"��");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public synchronized void sub(){
		try{
			Thread.sleep(500);
			j--;
			System.out.println("-- ��"+j+"��");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}