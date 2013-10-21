package com.zyg.javaio.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	/**@author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String filePath = "D:\\NewStudy\\JavaIODemo\\src\\com\\zyg" +
//				"\\javaio\basic\\FileInputStreamTest.java";
		
		String filePath = "D:/NewStudy/JavaIODemo/src/com/zyg" +
				"/javaio/basic/FileInputStreamTest.java";
		
		//读取本java文件内容
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
			System.out.println("读取完毕，共读取："+num+"个字节！");
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
			System.exit(-1);
		} catch(IOException e){
			System.out.println("文件读取错误！");
			System.exit(-1);
		}
	}
}
