package com.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*������ʽ�ķ���*/
public class test8 {
    public static void group1()
    {
    	Pattern p = Pattern.compile("\\d{3,5}[a-z]{2}");
		String s = "123aa-34345bb-234cc-00";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group(0)); /*�������ʽΪ��0��*/
		}	
    }
	
    
    public static void group2()
    {
    	Pattern p = Pattern.compile("(\\d{3,5})([a-z]{2})"); //(\\d{3,5})��һ�飺([a-z]{2})���ڶ���
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
