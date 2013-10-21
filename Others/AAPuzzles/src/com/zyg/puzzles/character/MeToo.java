package com.zyg.puzzles.character;

import java.io.File;
import java.util.regex.Matcher;

public class MeToo {
	public static void main(String[] args) {
		/*System.out.println(MeToo.class.getName().
				replaceAll("\\.", File.separator) + ".class");*/
	
		//方案1
		System.out.println("File.separator:"+File.separator);
		System.out.println(Matcher.quoteReplacement(File.separator));
		System.out.println(MeToo.class.getName().replaceAll("\\.",
				Matcher.quoteReplacement(File.separator)) + ".class");
		//方案2
		System.out.println(MeToo.class.getName().
				replace(".", File.separator) + ".class");
		
		//方案3
		System.out.println("File.separatorChar:"+File.separatorChar);
		System.out.println(MeToo.class.getName().
				replace('.', File.separatorChar) + ".class");

	}

}
