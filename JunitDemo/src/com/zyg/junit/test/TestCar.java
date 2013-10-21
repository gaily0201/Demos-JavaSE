package com.zyg.junit.test;

import junit.framework.*;

public class TestCar extends TestCase {
	protected int expectedWheels;
	protected Car myCar;
	
	public static Test suite() {
		return new TestSuite(TestCar.class);
	}
	
/*	public TestCar(String s) {
		super(s);
		System.out.println("TestCar(String s) " +s);
	}*/

	protected void setUp() {
		System.out.println("--------------------------------------------");
		System.out.println("1:void setUp");
		expectedWheels = 6;
		myCar = new Car();
	}

	public void testGetWheels() {
		//һ���򵥵Ĳ��Է������ж�expectedWheels��ֵ��myCar����ȡ�����ֵ�Ƿ����
		//assertEquals(expectedWheels, myCar.getWheels());
		
		System.out.println("2:testGetWheels ����ͨ��");
	}
	
	public void testHaha(){
		System.out.println("3:testHaha  ����ͨ��");
	}
	
	/*public void test(){
		System.out.println("4:test  ����ͨ��");
	}*/
	
	protected void tearDown() {//todo
		System.out.println("tearDown");
	}

}
