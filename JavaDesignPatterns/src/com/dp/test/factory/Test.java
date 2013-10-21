package com.dp.test.factory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IWorkFactory studentWorkFactory = new StudentWorkFactory();
		studentWorkFactory.getWork().dowork();
		
		IWorkFactory teacherWorkFacotry = new TeacherWorkFactory();
		teacherWorkFacotry.getWork().dowork();
	}

}
