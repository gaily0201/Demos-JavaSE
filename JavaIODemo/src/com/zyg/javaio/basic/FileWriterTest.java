package com.zyg.javaio.basic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String srcFilePath= "D:/NewStudy/JavaIODemo/src/com/zyg" +
							 "/javaio/basic/FileWriterTest.java";
		
		String destFilePath="D:/NewStudy/JavaIODemo/src/com/zyg" +
		 					"/javaio/basic/FileWriterTest_2.java";
		//复制文件
		FileWriterTest fwt = new FileWriterTest();
		fwt.CopyFile(srcFilePath, destFilePath);
	}
	
	private void CopyFile(String srcFilePath,String destFilePath){
		FileReader fr = null;
		FileWriter fw = null;
		try {
			//字符输入流
			fr = new FileReader(srcFilePath);
			//字符输出流
			fw = new FileWriter(destFilePath);
			
			int b=0;
			while((b=fr.read())!=-1){
				//System.out.print((char)b);
				fw.write(b);
			}
			
			fr.close();
			fw.close();
			System.out.println("文件复制完毕！");
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
			System.exit(-1);
		} catch(IOException e){
			System.out.println("文件读取错误！");
			System.exit(-1);
		}
	}
}
