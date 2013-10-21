package com.zyg.mianshiti;
public class Singleton {
	private static Singleton single = new Singleton();

	private Singleton() {
	}

	public Singleton getInstance() {
		return single;
	}
}
