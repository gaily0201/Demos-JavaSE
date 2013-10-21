package com.zyg.puzzles.loopy;

public class looper28 {
	public static void main(String[] args) {
		//double i = 1.0 / 0.0;
		double i = Double.POSITIVE_INFINITY;
		
		while(i == i + 1) {
			System.out.println("¥Ú”°¡À");
		}
		//int i = Integer.MAX_VALUE;
		System.out.println(i);
		System.out.println(i+1);
	}
}
