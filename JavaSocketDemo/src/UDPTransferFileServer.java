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
	 * @author �����
	 * @param args
	 */
	public static void main(String[] args) {
		UDPTransferFileServer utfs = new UDPTransferFileServer();
		
		System.out.println("��������׼�������ļ�...");
		Date d = new Date();
		String filePath = "d:/"+d.getTime()+".java";
		int serverPort = 6969;
		
		utfs.setFilePath(filePath);
		utfs.setServerPort(serverPort);
		//���տͻ��˷������ļ�
		utfs.receiveFile();
	}

	//���տͻ��˷������ļ�
	public void receiveFile() {
		//�����ļ�
		createFile();
		//�����ļ�
		fileWriter = createFile();
		//�ӿͻ��˽�������
		receiveData();
	}
	
	private Writer createFile() {
		BufferedWriter fileWriter = null;
		try {
			//���ֽ���תΪ�ַ���
			fileWriter = new BufferedWriter(new FileWriter(filePath, true));
		} catch (FileNotFoundException e) {
			System.out.println("�Ҳ����ļ���" + filePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("���ļ�����" + filePath);
			e.printStackTrace();
		}

		return fileWriter;
	}

	//�������ݱ�
	private void receiveData() {
		byte[] datagram = new byte[1024];
		DatagramPacket dp = null;
		try {
			if (ds == null) {
				ds = new DatagramSocket(serverPort);
			}
			dp = new DatagramPacket(datagram, datagram.length);
			//�������ݰ�
			while (true) {
				ds.receive(dp);
				String mess = new String(datagram, 0, dp.getLength());

				//���ַ���д���ļ�
				fileWriter.write(mess);
				fileWriter.flush();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//�ر����ݱ���socket
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
