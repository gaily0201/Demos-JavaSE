package com.zyg.puzzles.loopy;

public class DownForCount {
	public static void main(String[] args) {
		final int START = 2000000000;
		int count = 0;
		for (float f = START; f < START + 50; f++){
			count++;
		}
		System.out.println(count);
		
		//Á·Ï°Ò»ÏÂ
		System.out.println((float)2000000000);
		System.out.println((float)2000000050);
		System.out.println((float)2000000064);
	}
}
