package com.zyg.puzzles.character;

public class ABC {

	public static void main(String[] args) {
		String letters = "ABC";
		char[] numbers = {'1', '2', '3'};
		
		System.out.println(numbers);
		System.out.println(letters + " easy as " + numbers);
		
		//方案1
		System.out.println(letters + " easy as " +
				String.valueOf(numbers));
		//方案2
		System.out.print(letters + " easy as ");
		System.out.println(numbers);
		
		ABC2();
	}
	
	private static void ABC2(){
		String letters = "ABCD";
		Object numbers = new char[] { '1', '2', '3','4' };
		System.out.print(letters + " easy as ");
		System.out.println(numbers);
	}
}

