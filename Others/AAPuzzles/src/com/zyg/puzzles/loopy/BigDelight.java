package com.zyg.puzzles.loopy;

public class BigDelight {
	private static final byte TARGET = (byte)0x90;
	
	public static void main(String[] args) {
		for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
			if (b == TARGET)
				System.out.print("Joy!");
		}
	}
}
