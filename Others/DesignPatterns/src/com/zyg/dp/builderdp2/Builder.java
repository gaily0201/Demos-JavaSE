package com.zyg.dp.builderdp2;

public interface Builder {
	//����������˵
	public abstract void carPart1();
	public abstract void carPart2();
	public abstract void carPart3();
	public abstract Car carOver();
	
	//�Ի���˵
	public abstract void trainPart();
	public abstract void loco();
	public abstract Train trainOver();
}
