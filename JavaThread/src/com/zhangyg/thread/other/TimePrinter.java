package com.zhangyg.thread.other;

import java.util.Date;

public class TimePrinter extends Thread {
	int pauseTime;
	String name;

	public TimePrinter(int x, String n) {
		pauseTime = x;
		name = n;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(name + ":"
						+ new Date(System.currentTimeMillis()));
				Thread.sleep(pauseTime);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	static public void main(String args[]) {
		TimePrinter tp1 = new TimePrinter(1000, "Fast Guy");
		tp1.start();
		TimePrinter tp2 = new TimePrinter(3000, "Slow Guy");
		tp2.start();
	}
}
