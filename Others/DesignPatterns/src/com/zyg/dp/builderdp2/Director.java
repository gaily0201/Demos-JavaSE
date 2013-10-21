package com.zyg.dp.builderdp2;

public class Director {
	private BuilderCar bc=new BuilderCar();
	private BuilderTrain bt=new BuilderTrain();
	//ÃüÁîÔìÆû³µ
	public Car buildCar(){
		bc.carPart1();
		bc.carPart2();
		bc.carPart3();
		Car car=bc.carOver();
		return car;
	}
	
	//ÃüÁîÔç»ğ³µ
	public Train buildTrain(){
		bt.trainPart();
		bt.loco();
		Train train=bt.trainOver();
		return train;
	}
	
}
