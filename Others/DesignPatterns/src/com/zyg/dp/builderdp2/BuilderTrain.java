package com.zyg.dp.builderdp2;

public class BuilderTrain {
	private Train train=new Train();
	public  void trainPart(){
		System.out.println("�𳵵ĳ��������");
	}
	public  void loco(){
		System.out.println("��ͷ�����");
	}
	public  Train trainOver(){
		return train;
	}
}
