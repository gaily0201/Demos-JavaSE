package com.zyg.puzzles.character;

import java.util.regex.Pattern;

public class Me {

	public static void main(String[] args) {
		System.out.println(
				Me.class.getName().
				replaceAll(".","/") + ".class");
		
		//����1
		System.out.println(
				Me.class.getName().
				replaceAll("\\.","/") + ".class");
		
		//����2
		System.out.println(Me.class.getName().
				replaceAll(Pattern.quote("."),"/") + ".class");
	}
}
