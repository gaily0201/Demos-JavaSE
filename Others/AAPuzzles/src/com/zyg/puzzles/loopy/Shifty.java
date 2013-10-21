package com.zyg.puzzles.loopy;

public class Shifty {

	public static void main(String[] args) {
		/*int i = 0;
		while (-1 << i != 0){
			i++;
		}
		System.out.println(i);*/
		int distance = 0;
		for (int val = -1; val != 0; val <<= 1){
			distance++;
		}
		System.out.println(distance);
		
		System.out.println(-1<<32);
		
		System.out.println(-2>>>31);
	}

}
