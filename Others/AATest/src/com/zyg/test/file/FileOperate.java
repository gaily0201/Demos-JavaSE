package com.zyg.test.file;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class FileOperate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filePath = "D:\\test\\";
		try {
			File dir = new File(filePath);
			String[] fs = dir.list();
			for (int i = 0; i < fs.length; i++) {
				if (fs[i].indexOf(".") != -1) {
					if (fs[i].contains("¸´¼þ")) {
						dir = new File(filePath + "\\" + fs[i]);
						FileUtils.forceDelete(dir);
						//dir.delete();
						System.out.println("É¾³ý"+fs[i]);
						//System.out.println(fs[i]);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
