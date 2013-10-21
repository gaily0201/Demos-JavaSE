package com.zyg.javaio.buffer;
//���ͣ�http://blog.csdn.net/m_changgong
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferStreamTest {

	/**
	 * @author �����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "D:/NewStudy/JavaIODemo/src/com/zyg" +
		"/javaio/buffer/BufferStreamTest.java";
		
		BufferStreamTest bst = new BufferStreamTest();
		bst.read(filePath);
	}
	
	private void read(String filePath){
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream(filePath);
			bis = new BufferedInputStream(fis);
			
			System.out.println((char)bis.read());
			System.out.println((char)bis.read());
			
			bis.mark(100);         //�������ð���������
			
			int c=0;
			for(int i=0;i<=20 && (c=bis.read())!=-1;i++){
				System.out.print((char)c);
				
			}
			
			System.out.println();
			System.out.println("--------------------");
			
			bis.reset();
			for(int i=0;i<=20 && (c=bis.read())!=-1;i++){
				System.out.print((char)c);
				
			}
			
			bis.close();
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ڣ�");
		} catch(IOException e){
			System.out.println("�ļ���ȡ����");
		}
		
	}
}
