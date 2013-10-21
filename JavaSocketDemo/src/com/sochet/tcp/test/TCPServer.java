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
			System.out.println("一个客户端连接上！");
			
			DataInputStream dis = new DataInputStream(sc.getInputStream());
			
			System.out.println(sc.getLocalPort()+"说："+dis.readUTF());
			dis.close();
			ss.close();
		}
	}
}
