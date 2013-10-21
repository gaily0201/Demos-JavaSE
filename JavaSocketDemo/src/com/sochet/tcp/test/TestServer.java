package com.sochet.tcp.test;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String[] args) {
		ServerSocket ss =  null;
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			while(true){
				ss = new ServerSocket(5556);
				Socket sc  = ss.accept();
				
				os = sc.getOutputStream();
				dos = new DataOutputStream(os);
				dos.writeUTF("Hello,"+sc.getInetAddress()
							+" port:"+sc.getPort()+" byebye!");
				
				os.close();
				dos.close();
				sc.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
