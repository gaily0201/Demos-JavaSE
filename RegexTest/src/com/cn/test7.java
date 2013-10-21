package com.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test7 {

	public static  void  search1()
	{
		Pattern p = Pattern.compile("java");
		Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
		
		while(m.find()) {
			 System.out.println(m.group());
		}
	}
	
	
	public static  void  search2()
	{
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE); /* Pattern.CASE_INSENSITIVE:常量规则：忽大小写 */
		Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
		
		while(m.find()) {
			 System.out.println(m.group());
		}
	}
	
	public static  void  search3()
	{
		Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
		StringBuffer buf = new StringBuffer();
		while(m.find()) {
		  m.appendReplacement(buf, "888"); /*将当前找到的进行替换并且换好后放到buf中去*/
		}
		m.appendTail(buf);
		System.out.println(buf);
	}
	
	public static void main(String[] args) {
		
		//search1();
		
		//search2();
		
		search3();
	}

}
