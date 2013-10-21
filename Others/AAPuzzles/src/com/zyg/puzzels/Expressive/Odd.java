package com.zyg.puzzels.Expressive;

public class Odd {

	public static void main(String[] args) {
		int i=1;
		System.out.println(isOdd(i));
		
	}
	
	public static boolean isOdd(int i){
		return i % 2 == 1;
	}
	
	public static boolean isOdd2(int i){
		return i % 2 != 0;
	}
	
	public static boolean isOdd3(int i){
		return (i & 1) != 0;
	}
}
