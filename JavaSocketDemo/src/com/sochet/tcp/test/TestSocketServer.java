package com.sochet.tcp.test;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TestSocketServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		InputStream is = null;
		OutputStream os= null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			ss = new ServerSocket(6969);
			Socket sc = ss.accept();
			//读取客户端消息流
			is = sc.getInputStream();
			dis = new DataInputStream(is);
			
			//向客户端发送消息流
			os = sc.getOutputStream();
			dos = new DataOutputStream(os);
			
			String mess = null;
			while(true){
				mess = dis.readUTF();
				if(!"exit".equalsIgnoreCase(mess) && !"quit".equalsIgnoreCase(mess)){
					System.out.println("Client:"+mess);
					//服务器端发消息
					mess = ServerSay();
					System.out.println("Server:"+mess);
					
					dos.writeUTF(mess);
				}else{
					is.close();
					dis.close();
					sc.close();
					return;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String ServerSay(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String mess = null;
		try {
			mess = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mess;
	}
}
