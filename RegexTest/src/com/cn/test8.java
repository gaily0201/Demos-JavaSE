package com.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*正则表达式的分组*/
public class test8 {
    public static void group1()
    {
    	Pattern p = Pattern.compile("\\d{3,5}[a-z]{2}");
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group(0)); /*整个表达式为第0组*/
		}	
    }
	
    
    public static void group2()
    {
    	Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})"); //(\\d{3,5})第一组：([a-z]{2})：第二组
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group(1));
			//System.out.println(m.group(2));
		}	
    }
	public static void main(String[] args) {
		//group1();
		 group2();
		
	}

}
