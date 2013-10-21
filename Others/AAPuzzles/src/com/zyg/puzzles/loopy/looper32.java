package com.zyg.puzzles.loopy;

public class looper32 {
	public static void main(String[] args) {

		Integer i = new Integer(0);
		Integer j = new Integer(0);
		System.out.println("i==j:"+(i==j));
		//自动拆箱
		System.out.println(i==0);
		/*while (i <= j && j <= i && i != j) {
			System.out.println("循环者的咒语");
		}*/
	}
}
