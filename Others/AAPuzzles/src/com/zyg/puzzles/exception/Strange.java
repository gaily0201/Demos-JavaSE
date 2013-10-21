package com.zyg.puzzles.exception;

public class Strange {
	public static void main(String[] args) throws Exception {
		try {
			Object m = Class.forName("Missing").newInstance();
		} catch (ClassNotFoundException ex) {
			System.err.println("Got it!");
		}
	}
}
