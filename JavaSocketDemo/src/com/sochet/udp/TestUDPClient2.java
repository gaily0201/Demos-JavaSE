package com.sochet.udp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TestUDPClient2 {
	public static void main(String[] args) {
		//将long类型数据打包发送
		try {
			Long n = 10000L;
			ByteArrayOutputStream  baos = new ByteArrayOutputStream(1024);
			DataOutputStream dos = new DataOutputStream(baos);
			dos.writeLong(n);
			
			byte[] buffer = baos.toByteArray();
			
			DatagramSocket ds = new DatagramSocket(6969);
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length,
					new InetSocketAddress("localhost", 5678));
			
			baos.close();
			dos.close();
			
			ds.send(dp);
			ds.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
