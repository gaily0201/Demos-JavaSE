import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPTransferFileClient {
	private int serverPort = 6969;
	private int clientPort = 5656;
	private String serverIP = "localhost";
	private DatagramSocket ds = null;

	/**
	 * @author 张燕广
	 * @param args
	 * UDP传输文件客户端类
	 */
	public static void main(String[] args) {
		UDPTransferFileClient utfc = new UDPTransferFileClient();

		String filePath = "D:/NewStudy/JavaSocketDemo/src/UDPTransferFileClient.java";
		int serverPort = 6969;
		String serverIP = "localhost";
		
		System.out.println("客户端准备发送文件...");
		utfc.setServerPort(serverPort);
		utfc.setServerIP(serverIP);
		
		//往服务器端发送文件
		utfc.sendFile(filePath);
		
		System.out.println("客户端文件发送完毕！");
		System.out.println("文件：" + filePath);
	}

	//读取文件内容
	public void sendFile(String filePath) {
		int bufLen = 1024;

		FileInputStream fis = null;
		BufferedInputStream bis = null;

		try {
			fis = new FileInputStream(filePath);
			bis = new BufferedInputStream(fis);

			int off = 0;
			int bisLen = bis.available();
			byte[] buf = new byte[bufLen];
			while (off <= bisLen) {
				if (bisLen - off < bufLen) {
					buf = new byte[bisLen - off];
				}
				//读取数据到buf
				bis.read(buf);
				//将字节数组打包发送到服务器端
				sendData(buf);
				off = off + bufLen;
			}

			//关闭数据报包socket
			if (ds != null) {
				ds.close();
			}

			//关闭流
			fis.close();
			bis.close();
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件：" + filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("读取文件错误，文件名称为：" + filePath);
			e.printStackTrace();
		}
	}

	//发送数据报到服务器
	private void sendData(byte[] datagram) {
		DatagramPacket dp = null;
		try {
			if (ds == null) {
				ds = new DatagramSocket(clientPort);
			}

			dp = new DatagramPacket(datagram, datagram.length,
					new InetSocketAddress(serverIP, serverPort));
			//发送数据包
			ds.send(dp);

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public int getClientPort() {
		return clientPort;
	}

	public void setClientPort(int clientPort) {
		this.clientPort = clientPort;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public DatagramSocket getDs() {
		return ds;
	}

	public void setDs(DatagramSocket ds) {
		this.ds = ds;
	}
}
