package com.zyg.javaio.datastream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataStreamTest {

	/**
	 * @author �����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataStreamTest tst = new DataStreamTest();
		
		tst.test();
	}

	public void test(){
		ByteArrayOutputStream baos = null;
		DataOutputStream dos = null;
		
		ByteArrayInputStream bais = null;
		DataInputStream dis = null;
		
		try {
			//�����
			baos = new ByteArrayOutputStream();
			dos = new DataOutputStream(baos);
			//������д�����ڴ���
			dos.writeDouble(new Double(3));
			dos.writeBoolean(true);
			baos.close();
			dos.close();
			
			//������
			bais = new ByteArrayInputStream(baos.toByteArray());
			dis = new DataInputStream(bais);
			
			System.out.println("���������磺");
			
			/*for(int i=0;i<8;i++){
				System.out.println(dis.readBoolean());
			}*/
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			
			bais.close();
			dis.close();
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ڣ�");
		} catch (IOException e) {
			System.out.println("�ļ���ȡ����");
		}
	}
}
