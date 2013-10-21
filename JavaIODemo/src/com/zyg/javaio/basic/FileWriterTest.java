package com.zyg.javaio.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	/**
	 * @author �����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String srcFilePath= "D:/NewStudy/JavaIODemo/src/com/zyg" +
							 "/javaio/basic/FileWriterTest.java";
		
		String destFilePath="D:/NewStudy/JavaIODemo/src/com/zyg" +
		 					"/javaio/basic/FileWriterTest_2.java";
		//�����ļ�
		FileWriterTest fwt = new FileWriterTest();
		fwt.CopyFile(srcFilePath, destFilePath);
	}
	
	private void CopyFile(String srcFilePath,String destFilePath){
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//�ַ�������
			fr = new FileReader(srcFilePath);
			//�ַ������
			fw = new FileWriter(destFilePath);
			
			int b=0;
			while((b=fr.read())!=-1){
				//System.out.print((char)b);
				fw.write(b);
			}
			
			fr.close();
			fw.close();
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
