package com.zyg.puzzles.loopy;

public class Increment {
	
	private static int k = 0;
	public static void main(String[] args) {
		int j = 0;
		int n = 0;
		for (int i = 0; i < 100; i++){
			//System.out.println(i);
			j = j++;
			k = k++;
			n = ++n;
		}
		System.out.println("n:="+n);
		System.out.println("j:="+j);
		System.out.println("k:="+k);
	}
}
