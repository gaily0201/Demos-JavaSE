package com.zyg.dp.builderdp;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Director d=new Director();
		Car car=d.buildCar();
		System.out.println(car);
	}
}
