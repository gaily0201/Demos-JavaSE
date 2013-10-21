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
	 * @author �����
	 * @param args
	 * UDP�����ļ��ͻ�����
	 */
	public static void main(String[] args) {
		UDPTransferFileClient utfc = new UDPTransferFileClient();

		String filePath = "D:/NewStudy/JavaSocketDemo/src/UDPTransferFileClient.java";
		int serverPort = 6969;
		String serverIP = "localhost";
		
		System.out.println("�ͻ���׼�������ļ�...");
		utfc.setServerPort(serverPort);
		utfc.setServerIP(serverIP);
		
		//���������˷����ļ�
		utfc.sendFile(filePath);
		
		System.out.println("�ͻ����ļ�������ϣ�");
		System.out.println("�ļ���" + filePath);
	}

	//��ȡ�ļ�����
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
				//��ȡ���ݵ�buf
				bis.read(buf);
				//���ֽ����������͵���������
				sendData(buf);
				off = off + bufLen;
			}

			//�ر����ݱ���socket
			if (ds != null) {
				ds.close();
			}

			//�ر���
			fis.close();
			bis.close();
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ����ļ���" + filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��ȡ�ļ������ļ�����Ϊ��" + filePath);
			e.printStackTrace();
		}
	}

	//�������ݱ���������
	private void sendData(byte[] datagram) {
		DatagramPacket dp = null;
		try {
			if (ds == null) {
				ds = new DatagramSocket(clientPort);
			}

			dp = new DatagramPacket(datagram, datagram.length,
					new InetSocketAddress(serverIP, serverPort));
			//�������ݰ�
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
