package com.zyg.puzzles.loopy;

public class looper33 {
	public static void main(String[] args) {

		//int i = Integer.MIN_VALUE;
		long i = Long.MIN_VALUE;
		//byte i = Byte.MIN_VALUE;
		System.out.println(i);
		System.out.println(-i);
		/*while (i != 0 && i == -i) {
			System.out.println("¥Ú”°");
		}*/
		
		//¡∑œ∞
		System.out.println("byte---------------");
		byte n = Byte.MIN_VALUE;
		//System.out.println(Byte.toString(n));
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(-n));
		System.out.println(n);
		System.out.println(-n);
		
		System.out.println("short---------------");
		short y = Short.MIN_VALUE;
		System.out.println(y);
		System.out.println(-y);
		
		System.out.println("int---------------");
		int k = Integer.MIN_VALUE;
		System.out.println(Integer.toBinaryString(k));
		System.out.println(k);
		System.out.println(-k);
		
		System.out.println("long---------------");
		long lo = Long.MIN_VALUE;
		System.out.println(Long.toBinaryString(lo));
		System.out.println(Long.toBinaryString(-lo));
		System.out.println(lo);
		System.out.println(-lo);
	}
}
