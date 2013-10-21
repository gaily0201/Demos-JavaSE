package com.zyg.puzzles.exception;

public class Workout {
	//private static int counter = 1;
	public static void main(String[] args) {
		workHard();
		System.out.println("It's nap time.");
	}

	private static void workHard() {
		//counter++;
		try {
			workHard();
		} finally {
			
			//System.out.println("调用次数:"+counter);
			workHard();
		}
	}
}
