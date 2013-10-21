package com.cn;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cn.comm.Tools;


public class EmailSearch {

	public static void main(String[] args) {
		try {
			String path=Tools.getClassPath();
            String fileSource=path+"/file/888.html";
			BufferedReader br = new BufferedReader(new FileReader(fileSource));
			String line = "";
			while((line=br.readLine()) != null) {
				parse(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void parse(String line) {
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");
		Matcher m = p.matcher(line);
		while(m.find()) {
			System.out.println(m.group());
		}
	}

}
