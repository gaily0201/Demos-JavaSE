package com.dp.test.factory;

public class StudentWorkFactory implements IWorkFactory {
	public Work getWork() {
		return new StudentWork();
	}
}
