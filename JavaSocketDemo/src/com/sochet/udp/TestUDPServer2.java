package com.sochet.udp;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class TestUDPServer2 {
	public static void main(String[] args) {
		//将long类型包解开
		byte[] buffer = new byte[1024];
		try {
			DatagramSocket ds = new DatagramSocket(5678);
			DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
			
			while(true){
				ds.receive(dp);
				ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
				DataInputStream dis = new DataInputStream(bais);
				System.out.println(dis.readLong());
				
				bais.close();
				dis.close();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
