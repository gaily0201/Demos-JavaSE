import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;

public class UDPTransferFileServer {
	private int serverPort = 6969;
	private String filePath = null;
	private DatagramSocket ds = null;
	private Writer fileWriter = null;

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		UDPTransferFileServer utfs = new UDPTransferFileServer();
		
		System.out.println("服务器端准备接收文件...");
		Date d = new Date();
		String filePath = "d:/"+d.getTime()+".java";
		int serverPort = 6969;
		
		utfs.setFilePath(filePath);
		utfs.setServerPort(serverPort);
		//接收客户端发来的文件
		utfs.receiveFile();
	}

	//接收客户端发来的文件
	public void receiveFile() {
		//创建文件
		createFile();
		//创建文件
		fileWriter = createFile();
		//从客户端接收数据
		receiveData();
	}
	
	private Writer createFile() {
		BufferedWriter fileWriter = null;
		try {
			//将字节流转为字符流
			fileWriter = new BufferedWriter(new FileWriter(filePath, true));
		} catch (FileNotFoundException e) {
			System.out.println("找不到文件：" + filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("打开文件错误：" + filePath);
			e.printStackTrace();
		}

		return fileWriter;
	}

	//接收数据报
	private void receiveData() {
		byte[] datagram = new byte[1024];
		DatagramPacket dp = null;
		try {
			if (ds == null) {
				ds = new DatagramSocket(serverPort);
			}
			dp = new DatagramPacket(datagram, datagram.length);
			//接收数据包
			while (true) {
				ds.receive(dp);
				String mess = new String(datagram, 0, dp.getLength());

				//将字符串写入文件
				fileWriter.write(mess);
				fileWriter.flush();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//关闭数据报包socket
			ds.close();
		}
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
