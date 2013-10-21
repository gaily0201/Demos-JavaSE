package com.zyg.puzzles.character;

public class LastLaugh {
	public static void main(String[] args) {
		System.out.print("H"+"a");
		System.out.print('H'+'a');
		
		//方案1
		StringBuffer sb = new StringBuffer();
		sb.append('H');
		sb.append('a');
		System.out.println(sb);
		
		//方案2
		System.out.println("" + 'H' + 'a');
		
		//System.out.println("2 + 2 = " + 2+2);
		
		//方案3
		System.out.printf("%c%c", 'H', 'a');
	}

}
