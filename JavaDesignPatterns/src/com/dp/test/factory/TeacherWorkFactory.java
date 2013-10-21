package com.dp.test.factory;

public class TeacherWorkFactory implements IWorkFactory{
	public Work getWork() {
		return new TeacherWork();
	}
}
