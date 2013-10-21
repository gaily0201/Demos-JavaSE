package com.zhangyg.thread.other;

public class BSync {
	int totalThreads;
	int currentThreads;

	public BSync(int x) {
		totalThreads = x;
		currentThreads = 0;
	}

	public synchronized void waitForAll() {
		currentThreads++;
		if (currentThreads < totalThreads) {
			try {
				wait();
			} catch (Exception e) {
			}
		} else {
			currentThreads = 0;
			notifyAll();
		}
	}

}
