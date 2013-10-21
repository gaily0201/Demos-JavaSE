package com.zyg.javaio.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	/**@author �����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filePath = "D:/NewStudy/JavaIODemo/src/com/zyg" +
				"/javaio/basic/FileReaderTest.java";
		
		//��ȡ��java�ļ�����
		FileInput(filePath);
	}

	private static void FileInput(String filePath) {
		FileReader fr =  null;
		int b = 0;
		int num = 0;
		try {
			fr = new FileReader(filePath);

			while ((b = fr.read()) != -1) {
				System.out.print((char)b);
				num++;
			}
			
			fr.close();
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
