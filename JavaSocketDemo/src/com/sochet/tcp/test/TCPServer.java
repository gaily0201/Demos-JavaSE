package com.sochet.tcp.test;


import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(6666);
		
		while(true){
			Socket sc = ss.accept();
			System.out.println("һ���ͻ��������ϣ�");
			
			DataInputStream dis = new DataInputStream(sc.getInputStream());
			
			System.out.println(sc.getLocalPort()+"˵��"+dis.readUTF());
			dis.close();
			ss.close();
		}
	}
}
