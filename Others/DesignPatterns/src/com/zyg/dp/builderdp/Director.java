package com.zyg.dp.builderdp;

public class Director {
	private Builder b=new BuilderCar();
	
	//ÃüÁîÔìÆû³µ
	public Car buildCar(){
		b.carPart1();
		b.carPart2();
		b.carPart3();
		Car car=b.carOver();
		return car;
	}
}
