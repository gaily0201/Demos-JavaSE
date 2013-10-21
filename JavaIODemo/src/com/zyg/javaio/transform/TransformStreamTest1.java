package com.zyg.javaio.transform;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TransformStreamTest1 {

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "D:/NewStudy/JavaIODemo/trans1.txt";
		TransformStreamTest1 tst = new TransformStreamTest1();
		
		tst.test(filePath);
	}

	public void test(String filePath){
		OutputStreamWriter osw = null;
		try {
			osw  = new OutputStreamWriter(new FileOutputStream(filePath));
			osw.write("张燕广");
			System.out.println(osw.getEncoding());
			osw.close();
			
			osw  = new OutputStreamWriter(new FileOutputStream(filePath,true),"GBK");
			osw.write("\n");
			osw.write("张燕广2");
			
			System.out.println(osw.getEncoding());
			osw.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("文件读取错误！");
		}
	}
}
