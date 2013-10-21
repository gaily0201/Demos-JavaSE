package com.sochet.udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TestUDPClient {
	public static void main(String[] args) {
		byte[] buffer = new String("’≈—‡π„").getBytes();

		try {
			DatagramSocket ds = new DatagramSocket(6969);
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length,
					new InetSocketAddress("localhost", 5678));

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
