package com.zyg.javaio.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	/**
	 * @author �����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String srcFilePath= "D:/NewStudy/JavaIODemo/src/com/zyg" +
							 "/javaio/basic/FileInputStreamTest.java";
		String destFilePath="D:/NewStudy/JavaIODemo/src/com/zyg" +
		 					"/javaio/basic/FileInputStreamTest_2.java";
		//�����ļ�
		FileOutputStreamTest fost = new FileOutputStreamTest();
		fost.CopyFile(srcFilePath, destFilePath);
	}
	
	private void CopyFile(String srcFilePath,String destFilePath){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			//�ֽ�������
			fis = new FileInputStream(srcFilePath);
			//�ֽ������
			fos = new FileOutputStream(destFilePath);
			
			int b=0;
			while((b=fis.read())!=-1){
				fos.write(b);
			}
			
			fis.close();
			fos.close();
			
			System.out.println("�ļ�������ϣ�");
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ڣ�");
			System.exit(-1);
		} catch(IOException e){
			System.out.println("�ļ���ȡ����");
			System.exit(-1);
		} 
	}
}
