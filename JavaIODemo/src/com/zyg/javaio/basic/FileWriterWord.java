package com.zyg.javaio.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterWord {

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String destFilePath="D:/NewStudy/JavaIODemo/words.txt";
		//复制文件
		FileWriterWord fwt = new FileWriterWord();
		fwt.WriteWords(destFilePath);
	}
	
	private void WriteWords(String destFilePath){
		FileWriter fw = null;
		try {
			//输出字符流
			fw = new FileWriter(destFilePath);
			
			for(int i=0;i<50000;i++){
				fw.write(i);
			}
			
			fw.close();
			System.out.println("写入文字完毕！");
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
			System.exit(-1);
		} catch(IOException e){
			System.out.println("文件读取错误！");
			System.exit(-1);
		}
	}
}
