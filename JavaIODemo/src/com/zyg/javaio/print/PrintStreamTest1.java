package com.zyg.javaio.print;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest1 {

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "D:/NewStudy/JavaIODemo/print1.txt";
		
		PrintStreamTest1 pst = new PrintStreamTest1();
		pst.test(filePath);
		
	}

	private void test(String filePath){
		FileOutputStream fos = null;
		PrintStream ps = null;
		
		PrintStream temPS = null;
		try {
			fos = new FileOutputStream(filePath,true);
			ps = new PrintStream(fos);
			
			if(ps!=null){
				temPS = System.out;
				
				System.setOut(ps);
			}
			
			int ln = 0;
			for(char c=0;c<=60000;c++){
				//System.out.print(c);       为什么报错？
				//System.out.print(c+"");    为什么报错？
				System.out.print(c+" ");
				ln++;
				if(ln>=10){
					System.out.println();
					ln=0;
				}
			}
			
			fos.close();
			ps.flush();
			ps.close();
			
			
			System.setOut(temPS);
			System.out.println("程序执行完毕！");
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("文件读取错误！");
		}
	}
}
