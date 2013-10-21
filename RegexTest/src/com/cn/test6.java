package com.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test6 {

	public static void main(String[] args) {
		//email
		//[\\w[.-]]:表示任何字符并且或者是.或者是-(有的email地址前面是有.-的)
		//+：表示上面的出现一次或多次。
		System.out.println("zhangsan@yahoo.com".matches("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$"));
		System.out.println("111111111111111111111111111111111111111111111111");

		//matches find lookingAt
		Pattern p = Pattern.compile("\\d{3,5}"); /*数字出现3--5次*/
		String s = "123-34345-234-00"; 
		Matcher m = p.matcher(s); 
		System.out.println("m.matches()======="+m.matches());/*matches:是匹配整个字符串。一次吃5个字符去匹配*/
		System.out.println("2222222222222222222222222222222222222222222222222");
		
		m.reset(); /*字符串扫描归位：下面的从头开始扫描*/
		System.out.println("m.find()===="+m.find()); /*找一个匹配的字串而不是整个字符串*/
		System.out.println(m.start() + "-" + m.end());
		System.out.println("3333333333333333333333333333333333333333333333333");

		
		System.out.println("4444444444444444444444444444444444444444444444444444");
		System.out.println(m.lookingAt()); /*每次从头找匹配的子串*/
		System.out.println(m.lookingAt());
		System.out.println(m.lookingAt());
		System.out.println(m.lookingAt());
	}

}
