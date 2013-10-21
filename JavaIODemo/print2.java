package com.zyg.javaio.print;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest2 {

	/**
	 * @author ’≈—‡π„
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String filePath = "D:/NewStudy/JavaIODemo/src/com/zyg/javaio" 
						  +"/print/PrintStreamTest2.java";
		
		String printFile = "D:/NewStudy/JavaIODemo/print2.java";
		
		PrintStream ps1 = null;
		PrintStream ps2 = null;
		
		if(filePath!=null){
			ps1 = System.out;
			list(filePath,ps1);
			
			ps2 = new PrintStream(printFile);
			list(filePath,ps2);
		}
		
	}

	private static void list(String filePath,PrintStream ps)  throws Exception{
		FileReader fr = null;
		BufferedReader br = null;
		
		fr = new FileReader(filePath);
		br = new BufferedReader(fr);
		
		String s = null;
		while((s=br.readLine())!=null){
			ps.println(s);
		}
		
		br.close();
	}
}
