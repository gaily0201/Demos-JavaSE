package com.zyg.puzzles.loopy;

public class looper30 {
	public static void main(String[] args) {
		String i="����";
		while (i != i + 0) {
			System.out.println("��ӡ");
		}
		
		String j="����";
		System.out.println(j!=(j+0));
	}
}
