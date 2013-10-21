package com.zyg.javaio.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	/**@author �����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String filePath = "D:\\NewStudy\\JavaIODemo\\src\\com\\zyg" +
//				"\\javaio\basic\\FileInputStreamTest.java";
		
		String filePath = "D:/NewStudy/JavaIODemo/src/com/zyg" +
				"/javaio/basic/FileInputStreamTest.java";
		
		//��ȡ��java�ļ�����
		FileInput(filePath);
	}

	private static void FileInput(String filePath) {
		int b = 0;
		int num = 0;
		try {
			FileInputStream fis = new FileInputStream(filePath);

			while ((b = fis.read()) != -1) {
				System.out.print((char)b);
				num++;
			}
			
			fis.close();
			System.out.println("��ȡ��ϣ�����ȡ��"+num+"���ֽڣ�");
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ڣ�");
			System.exit(-1);
		} catch(IOException e){
			System.out.println("�ļ���ȡ����");
			System.exit(-1);
		}
	}
}
