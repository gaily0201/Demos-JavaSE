package com.zyg.javaio.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterWord {

	/**
	 * @author �����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String destFilePath="D:/NewStudy/JavaIODemo/words.txt";
		//�����ļ�
		FileWriterWord fwt = new FileWriterWord();
		fwt.WriteWords(destFilePath);
	}
	
	private void WriteWords(String destFilePath){
		FileWriter fw = null;
		try {
			//����ַ���
			fw = new FileWriter(destFilePath);
			
			for(int i=0;i<50000;i++){
				fw.write(i);
			}
			
			fw.close();
			System.out.println("д��������ϣ�");
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ڣ�");
			System.exit(-1);
		} catch(IOException e){
			System.out.println("�ļ���ȡ����");
			System.exit(-1);
		}
	}
}
