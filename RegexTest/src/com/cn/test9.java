package com.cn;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test9 {
	/*常用这个*/
	public static void fun1()
    {
    	Pattern p = Pattern.compile(".{3,10}[0-9]"); /*3到10个字符后面跟着一位数字:没有问号：一次吃10个字符发现不匹配于是吐出一个字符再去匹配......*/
		String s = "aaaa5bbbb6";
		Matcher m = p.matcher(s);
		if(m.find())
			System.out.println(m.start() + "-" + m.end());
		else 
			System.out.println("not match!");
    }
	
	
	
	/*勉强模式*/
    public static void fun2()
    {
    	Pattern p = Pattern.compile(".{3,10}?[0-9]"); /*第一次吃3个字符看符合不？此时第四个表示数子，因此不符合，再吃进一位：此时符合*/
		String s = "aaaa5bbbb68";
		Matcher m = p.matcher(s);
		if(m.find())
			System.out.println(m.start() + "-" + m.end());
		else 
			System.out.println("not match!");
    }
    
    /*一般不用:占有模式*/
    public static void fun3()
    {
    	Pattern p = Pattern.compile(".{3,10}+[0-9]");/*一次吃10个字符并且不往外吐*/
		String s = "aaaa5bbbb6";
		Matcher m = p.matcher(s);
		if(m.find())
			System.out.println(m.start() + "-" + m.end());
		else 
			System.out.println("not match!");
    }
    
    public static void fun4()
    {
    	Pattern p = Pattern.compile(".{3}"); 
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    	
    }
    
    public static void fun5()
    {
    	Pattern p = Pattern.compile(".{3}(?=a)"); /*(?=a)：表示非捕获组(不捕获a)：表示结束的字符是a*/
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    	
    }
	
    
    public static void fun6()
    {
    	Pattern p = Pattern.compile("(?=a).{3}"); /*(?=a)：表示非捕获组(不捕获a)：表示以a打头后面三个字符,包挂a*/
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    	
    }
    public static void fun7()
    {
    	Pattern p = Pattern.compile(".{3}(?=!a)"); 
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    	
    }
    
    
    public static void fun8()
    {
    	Pattern p = Pattern.compile(".{3}(?<=a)"); /*从后往前数还包含a的*/
		String s = "444a66b";
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
		}
    }
    
    /*向前引用*/
    public static void fun9()
    {
    	Pattern p = Pattern.compile("(\\d\\d)\\1");/*1:表示后面找到的结果必须和前面找到的一模一样*/
		String s = "1212";
		Matcher m = p.matcher(s);
		System.out.println(m.matches());		
    }
    /*向前引用*/
    public static void fun10()
    {
    	Pattern p = Pattern.compile("(\\d(\\d))\\2");/*(\\d(\\d)):这里是两个组：第二个组抓到的是2 后面的\\2:表示后面的要和第二个抓到数字一样*/
		String s = "122";
		Matcher m = p.matcher(s);
		System.out.println(m.matches());	
    }
    
    public  static void fun11()
    {
    	Pattern p = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
    	
    	System.out.println("Java".matches("(?i)(java)")); /*(?i)非捕获组:是上面的简写*/
    	
    }
    
	public static void main(String[] args) {
		 System.out.println("==================fun1();================================");
		 fun1();
		 System.out.println("==================fun2();================================");
		 fun2();
		 System.out.println("==================fun3();================================");
		 fun3();
		 System.out.println("==================fun4();================================");
		 fun4();
		 System.out.println("==================fun5();================================");
		 fun5();
		 System.out.println("==================fun6();================================");
		 fun6();
		 System.out.println("==================fun7();================================");
		 fun7();
		 System.out.println("==================fun8();================================");
		 fun8();
		 System.out.println("==================fun9();================================");
		 fun9();
		 System.out.println("==================fun10();================================");
		 fun10();
		 System.out.println("==================fun11();================================");
		 fun11();
	}

}
/*
在使用Pattern.compile函数时，可以加入控制正则表达式的匹配行为的参数：
Pattern Pattern.compile(String regex, int flag) 

flag的取值范围如下：
Pattern.CANON_EQ     当且仅当两个字符的"正规分解(canonical decomposition)"都完全相同的情况下，才认定匹配。比如用了这个标志之后，表达式"a\u030A"会匹配"?"。默认情况下，不考虑"规范相等性(canonical equivalence)"。
Pattern.CASE_INSENSITIVE(?i)     默认情况下，大小写不明感的匹配只适用于US-ASCII字符集。这个标志能让表达式忽略大小写进行匹配。要想对Unicode字符进行大小不明感的匹配，只要将UNICODE_CASE与这个标志合起来就行了。
Pattern.COMMENTS(?x)     在这种模式下，匹配时会忽略(正则表达式里的)空格字符(译者注：不是指表达式里的"\\s"，而是指表达式里的空格，tab，回车之类)。注释从#开始，一直到这行结束。可以通过嵌入式的标志来启用Unix行模式。
Pattern.DOTALL(?s)     在这种模式下，表达式''.''可以匹配任意字符，包括表示一行的结束符。默认情况下，表达式''.''不匹配行的结束符。
Pattern.MULTILINE
(?m)     在这种模式下，''^''和''$''分别匹配一行的开始和结束。此外，''^''仍然匹配字符串的开始，''$''也匹配字符串的结束。默认情况下，这两个表达式仅仅匹配字符串的开始和结束。
Pattern.UNICODE_CASE
(?u)     在这个模式下，如果你还启用了CASE_INSENSITIVE标志，那么它会对Unicode字符进行大小写不明感的匹配。默认情况下，大小写不敏感的匹配只适用于US-ASCII字符集。
Pattern.UNIX_LINES(?d)     在这个模式下，只有''\n''才被认作一行的中止，并且与''.''，''^''，以及''$''进行匹配。 
*/