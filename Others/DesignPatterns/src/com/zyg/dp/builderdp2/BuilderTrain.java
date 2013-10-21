package com.zyg.dp.builderdp2;

public class BuilderTrain {
	private Train train=new Train();
	public  void trainPart(){
		System.out.println("火车的车厢造好了");
	}
	public  void loco(){
		System.out.println("火车头造好了");
	}
	public  Train trainOver(){
		return train;
	}
}
