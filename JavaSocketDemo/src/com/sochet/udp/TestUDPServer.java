package com.sochet.udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class TestUDPServer {
	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		try {
			DatagramSocket ds = new DatagramSocket(5678);
			DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
			
			while(true){
				ds.receive(dp);
				String mess = new String(buffer,0,dp.getLength());
				
				System.out.println(mess);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
