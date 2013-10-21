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
		String inputFile = "D:\\TestLucene\\FileTest\\files\\�߳��������.txt";
		String outputDir = "D:\\TestLucene\\FileTest\\testfolder\\";
		if (!new File(outputDir).exists())
			new File(outputDir).mkdirs();
		FilePreprocess filePreprocess = new FilePreprocess();
		filePreprocess.preprocess(new File(inputFile), outputDir);
		
		System.out.println("�ļ���ʽ�����ָ����ϣ�");
	}
	
	//�����ļ�
	public static void preprocess(File file, String outputDir) {
		try {
			//�ָ��ļ�
			splitToSmallFiles(charactorProcess(file, outputDir + "output.all"),
					outputDir);
			
			File fileDelete = new File(outputDir + "output.all");
			if (fileDelete.exists()){
				System.out.println("ɾ����ʱ�ļ� output.all");
				fileDelete.delete();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�ַ�����
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
	
	//ȫ�ǵ���ǵ�ת��
	private static String replace(String line) {
		HashMap map = new HashMap();
		map.put("��", ",");
		map.put("��", ".");
		map.put("��", "<");
		map.put("��", ">");
		map.put("��", "|");
		map.put("��", "<");
		map.put("��", ">");
		map.put("��", "[");
		map.put("��", "]");
		map.put("�t", "?");
		map.put("��", "?");
		map.put("��", "\"");
		map.put("��", "\"");
		map.put("��", ":");
		map.put("��", ",");
		map.put("��", "(");
		map.put("��", ")");
		map.put("��", "[");
		map.put("��", "]");
		map.put("��", "-");
		map.put("��", "~");
		map.put("��", "!");
		map.put("�F", "'");
		map.put("��", "1");
		map.put("��", "2");
		map.put("��", "3");
		map.put("��", "4");
		map.put("��", "5");
		map.put("��", "6");
		map.put("��", "7");
		map.put("��", "8");
		map.put("��", "9");

		int length = line.length();
		for (int i = 0; i < length; i++) {
			String charat = line.substring(i, i + 1);
			if (map.get(charat) != null)
				line = line.replace(charat, (String) map.get(charat));
		}
		return line;
	}
	
	//�ָ��ļ�
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
