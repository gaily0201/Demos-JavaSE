package com.zyg.puzzles.character;

import java.util.regex.Pattern;

public class Me {

	public static void main(String[] args) {
		System.out.println(
				Me.class.getName().
				replaceAll(".","/") + ".class");
		
		//方案1
		System.out.println(
				Me.class.getName().
				replaceAll("\\.","/") + ".class");
		
		//方案2
		System.out.println(Me.class.getName().
				replaceAll(Pattern.quote("."),"/") + ".class");
	}
}
