package com.zyg.javaio.buffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferStreamTest2 {

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "D:/NewStudy/JavaIODemo/BufferStreamTest2.txt";

		BufferStreamTest2 bst = new BufferStreamTest2();
		bst.write(filePath);
		bst.read(filePath);
	}

	private void write(String filePath) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(filePath));

			for (int i = 0; i < 100; i++) {
				bw.write(String.valueOf(Math.random() * 200));
				bw.newLine();
			}

			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("文件读取错误！");
		}
	}

	private void read(String filePath) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(filePath));

			/*
			 * int c=0; for(int i=0;(c=br.read())!=-1;i++){
			 * System.out.print((char)c); }
			 */

			String s = null;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
		} catch (IOException e) {
			System.out.println("文件读取错误！");
		}
	}
}
