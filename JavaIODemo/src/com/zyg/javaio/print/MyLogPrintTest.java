package com.zyg.javaio.print;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

public class MyLogPrintTest {

	/**
	 * @author 张燕广
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String logFile = "D:/NewStudy/JavaIODemo/log.txt";
		
		PrintWriter log = null;
		log = new PrintWriter(new FileWriter(logFile,true));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		System.out.println("请输入内容：");
		
		while((s=br.readLine())!=null){
			if(s.equalsIgnoreCase("exit") 
			   || s.equalsIgnoreCase("quit")){
				break;
			}else{
				ExecLog(log,s);
				//log.print(s);
				//System.out.println(s);
			}
		}
		
		br.close();
		log.close();
		System.out.println("程序执行结束！");
	}

	private static void ExecLog(PrintWriter log,String logContent)  throws Exception{
		log.println("==="+ new Date() +"===");
		log.println(logContent);
		log.println("------------------------------------------------------");
	}
}
