package com.sochet.tcp.test;


import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Socket sc = new Socket("127.0.0.1",6666);
		
		OutputStream  os = sc.getOutputStream();
		DataOutputStream ds = new DataOutputStream(os);
		
		Thread.sleep(3000);
		
		ds.writeUTF("我是张燕广！");
		os.close();
		ds.close();
	}

}
