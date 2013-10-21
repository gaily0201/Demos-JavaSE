package com.zyg.dp.adapterdp;

interface Eat{
	public void eatBread();
	public void eatApple();
	public void eatBanana();
}

abstract class PersonEat implements Eat{
	public void eatBread(){
		
	}
	public void eatApple(){}
	public void eatBanana(){}
}

class Person extends PersonEat{
	public void eatBread(){
		System.out.println("���ڳ����");
	}
	
	public void eatApple(){
		System.out.println("���ڳ�ƻ��");
	}
}


public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p=new Person();
		p.eatBread();
		p.eatApple();

	}

}
