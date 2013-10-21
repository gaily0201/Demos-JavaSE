package com.zyg.dp.builderdp2;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Director d=new Director();
		//Car car=d.buildCar();
		//System.out.println(car);
		
		Train train=d.buildTrain();
		System.out.println(train);

	}

}
