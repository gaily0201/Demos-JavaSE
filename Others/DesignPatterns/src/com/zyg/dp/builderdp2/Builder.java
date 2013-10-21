package com.zyg.dp.builderdp2;

public interface Builder {
	//对于汽车来说
	public abstract void carPart1();
	public abstract void carPart2();
	public abstract void carPart3();
	public abstract Car carOver();
	
	//对火车来说
	public abstract void trainPart();
	public abstract void loco();
	public abstract Train trainOver();
}
