package com.sochet.tcp.test;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class TestClient {
	public static void main(String[] args) {
		Socket sc = null;
		InputStream is = null;
		DataInputStream dis = null;
		try {
			sc = new Socket("localhost",5556);
			is = sc.getInputStream();
			dis = new DataInputStream(is);
			
			System.out.println(dis.readUTF());
			
			is.close();
			dis.close();
			sc.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
