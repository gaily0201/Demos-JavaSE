package com.zyg.dp.builderdp;

public class BuilderCar extends Builder{
	private Car car=new Car();
	@Override
	public Car carOver() {
		// TODO Auto-generated method stub
		return car;
	}

	@Override
	public void carPart1() {
		System.out.println("������������");
		
	}

	@Override
	public void carPart2() {
		System.out.println("�������������");
		
	}

	@Override
	public void carPart3() {
		System.out.println("������̥�����");
		
	}

}
