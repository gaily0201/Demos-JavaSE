package com.lucene.zyg.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.Set;

public class FilePreprocess {
	public static void main(String[] args) {
		String inputFile = "D:\\TestLucene\\FileTest\\files\\走出软件作坊.txt";
		String outputDir = "D:\\TestLucene\\FileTest\\testfolder\\";
		if (!new File(outputDir).exists())
			new File(outputDir).mkdirs();
		FilePreprocess filePreprocess = new FilePreprocess();
		filePreprocess.preprocess(new File(inputFile), outputDir);
		
		System.out.println("文件格式化及分割处理完毕！");
	}
	
	//处理文件
	public static void preprocess(File file, String outputDir) {
		try {
			//分割文件
			splitToSmallFiles(charactorProcess(file, outputDir + "output.all"),
					outputDir);
			
			File fileDelete = new File(outputDir + "output.all");
			if (fileDelete.exists()){
				System.out.println("删除临时文件 output.all");
				fileDelete.delete();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//字符处理
	public static File charactorProcess(File file, String destFile)
	throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter(destFile));
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine();
		while (line != null) {
			if (!line.equals("\r\n")) {
				String newline = replace(line);
				writer.write(newline);
				writer.newLine();
			}
			line = reader.readLine();
		}

		reader.close();
		writer.close();
		return new File(destFile);
	}
	
	//全角到半角的转换
	private static String replace(String line) {
		HashMap map = new HashMap();
		map.put("，", ",");
		map.put("。", ".");
		map.put("〈", "<");
		map.put("〉", ">");
		map.put("‖", "|");
		map.put("《", "<");
		map.put("》", ">");
		map.put("〔", "[");
		map.put("〕", "]");
		map.put("﹖", "?");
		map.put("？", "?");
		map.put("“", "\"");
		map.put("”", "\"");
		map.put("：", ":");
		map.put("、", ",");
		map.put("（", "(");
		map.put("）", ")");
		map.put("【", "[");
		map.put("】", "]");
		map.put("—", "-");
		map.put("～", "~");
		map.put("！", "!");
		map.put("‵", "'");
		map.put("①", "1");
		map.put("②", "2");
		map.put("③", "3");
		map.put("④", "4");
		map.put("⑤", "5");
		map.put("⑥", "6");
		map.put("⑦", "7");
		map.put("⑧", "8");
		map.put("⑨", "9");

		int length = line.length();
		for (int i = 0; i < length; i++) {
			String charat = line.substring(i, i + 1);
			if (map.get(charat) != null)
				line = line.replace(charat, (String) map.get(charat));
		}
		return line;
	}
	
	//分割文件
	public static void splitToSmallFiles(File file, String outputpath)
	throws IOException {
		int filePointer = 0;
		int MAX_SIZE = 10240;

		BufferedWriter writer = null;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		StringBuffer buffer = new StringBuffer();
		String line = reader.readLine();

		while (line != null) {
			buffer.append(line).append("\r\n");
			if (buffer.toString().getBytes().length >= MAX_SIZE)
			{
				writer = new BufferedWriter(new FileWriter(outputpath
						+ "output" + filePointer + ".txt"));
				writer.write(buffer.toString());
				writer.close();
				filePointer++;
				buffer = new StringBuffer();
			}
			line = reader.readLine();
		}
		writer = new BufferedWriter(new FileWriter(outputpath + "output"
				+ filePointer + ".txt"));
		
		writer.write(buffer.toString());
		writer.close();
	}
}
