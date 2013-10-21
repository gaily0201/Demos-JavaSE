package com.zyg.javaio.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String srcFilePath= "D:/NewStudy/JavaIODemo/src/com/zyg" +
							 "/javaio/basic/FileInputStreamTest.java";
		String destFilePath="D:/NewStudy/JavaIODemo/src/com/zyg" +
		 					"/javaio/basic/FileInputStreamTest_2.java";
		//复制文件
		FileOutputStreamTest fost = new FileOutputStreamTest();
		fost.CopyFile(srcFilePath, destFilePath);
	}
	
	private void CopyFile(String srcFilePath,String destFilePath){
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			//字节输入流
			fis = new FileInputStream(srcFilePath);
			//字节输出流
			fos = new FileOutputStream(destFilePath);
			
			int b=0;
			while((b=fis.read())!=-1){
				fos.write(b);
			}
			
			fis.close();
			fos.close();
			
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
