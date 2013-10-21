package com.zyg.javaio.transform;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformStreamTest2 {

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransformStreamTest2 tst = new TransformStreamTest2();
		
		tst.test();
	}

	public void test(){
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr  = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			
			String s = null;
			System.out.println("请输入内容：");
			while((s=br.readLine())!=null){
				if(s.equalsIgnoreCase("exit") || s.equalsIgnoreCase("quit")){
					System.out.println("程序退出！");
					System.exit(-1);
				}else{
					System.out.println(s);
				}
			}
			
			isr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("文件读取错误！");
		}
	}
}
