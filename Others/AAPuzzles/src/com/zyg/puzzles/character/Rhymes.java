package com.zyg.puzzles.character;

import java.util.Random;

public class Rhymes {
	private static Random rnd = new Random();
	public static void main(String[] args) {
		StringBuffer word = null;
		switch(rnd.nextInt(3)) {
		case 1:
			word = new StringBuffer("P");
			break;
		case 2: 
			word = new StringBuffer("G");
			break;
		default: 
			word = new StringBuffer("M");
			break;
		}
		word.append('a');
		word.append('i');
		word.append('n');
		System.out.println(word);
		
		//Rhymes2
		System.out.println("PGM".charAt(rnd.nextInt(3)) + "ain");
	}
}
