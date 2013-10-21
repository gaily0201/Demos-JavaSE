package com.zyg.puzzles.exception;

public class HelloGoodbye {

	public static void main(String[] args) {
		/*try {
			System.out.println("Hello world");
			System.exit(0);
		} finally {
			System.out.println("Goodbye world");
		}*/
		
		//·½°¸
		System.out.println("Hello world");
		Runtime.getRuntime().addShutdownHook(
		new Thread() {
			public void run() {
				System.out.println("Goodbye world");
			}
		}
		);
			System.exit(0);
		}
}
