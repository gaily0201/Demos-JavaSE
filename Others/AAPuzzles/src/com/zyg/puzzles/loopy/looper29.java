package com.zyg.puzzles.loopy;

public class looper29 {
	public static void main(String[] args) {
		
		double i = 0;
		while(i != i) {
			System.out.println("打印了");
		}
		
		float k = Float.NaN;
		while(k != k) {
			System.out.println("k 打印了");
		}
		
		double j = 0.0 / 0.0;
		System.out.println(j - j == 0);
		
		System.out.println(j==(j+0));
	}
}
