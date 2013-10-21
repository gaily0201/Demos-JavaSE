package com.sochet.tcp.test;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;


public class TestSocketClient {

	public static void main(String[] args) {
		Socket sc = null;
		InputStream is = null;
		OutputStream os= null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		try {
			sc = new Socket("localhost",6969);
			
			//往服务器端发送消息
			os = sc.getOutputStream();
			dos = new DataOutputStream(os);
			
			//从服务器端读取消息
			is = sc.getInputStream();
			dis = new DataInputStream(is);
			
			String mess = null;
			while(true){
				mess = ClientSay();
				if(mess.length()!=0 && !"exit".equalsIgnoreCase(mess) && !"quit".equalsIgnoreCase(mess)){
					dos.writeUTF("Client:"+mess);
					
					mess = dis.readUTF();
					System.out.println("Server:"+mess);
				}else{
					dos.writeUTF("Client:"+"Bye!");
					
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
	
	private static String ClientSay(){
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
