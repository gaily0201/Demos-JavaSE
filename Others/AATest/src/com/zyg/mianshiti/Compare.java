package com.zyg.mianshiti;
/**  
 * 不用比较运算符，判断int型的a，b两数的大小.  
 *   
 * @author JAVA世纪网(java2000.net, laozizhu.com)  
 */  
public class Compare {
	public static void main(String[] args) {   
	    int a = 30;   
	    int b = 2;   
	    String[] buf = { "a>=b", "a < b" };   
	    int id1 = (a - b) >> 31;   
	    System.out.println(id1); // 1   
	    System.out.println(buf[id1]); // a < b   
	  }
}
