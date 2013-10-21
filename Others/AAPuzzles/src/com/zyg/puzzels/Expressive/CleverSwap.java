package com.zyg.puzzels.Expressive;

public class CleverSwap {
	public static void main(String[] args) {
		int x = 1984; // (0x7c0)
		int y = 2001; // (0x7d1)
		//x^= y^= x^= y;
		//System.out.println("x= " + x + "; y= " + y);
		
		// Java 中x^= y^= x^= y 的实际行为
		/*int tmp1 = x ; // x 在表达式中第一次出现
		int tmp2 = y ; // y 的第一次出现
		int tmp3 = x ^ y ; // 计算x ^ y
		x = tmp3 ; // 最后一个赋值：存储x ^ y 到 x
		y = tmp2 ^ tmp3 ; // 第二个赋值：存储最初的x 值到y 中
		x = tmp1 ^ y ; // 第一个赋值：存储0 到x 中
*/		
		// 杀鸡用牛刀的做法，千万不要这么做！
		y = (x^= (y^= x))^ y ;
		System.out.println("x= " + x + "; y= " + y);
	}

}
