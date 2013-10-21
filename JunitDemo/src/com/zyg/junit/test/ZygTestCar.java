package com.zyg.junit.test;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ZygTestCar extends TestCase {
	protected int expectedWheels;
	protected Car myCar;

	public static Test suite() {
/*1		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestCar_2.class);*/
		
//2	    TestSuite suite = new TestSuite(TestCar_2.class);
		
		TestSuite suite = new TestSuite();
		suite.addTest(new TestSuite(ZygTestCar.class));
		
		TestSetup wrapper = new TestSetup(suite) {

			protected void setUp() {
				oneTimeSetUp();
			}
			protected void tearDown() {
				oneTimeTearDown();
			}
		};

		return wrapper;
	}

	public static void oneTimeSetUp() {
		System.out.println("打开数据库连接。。。。。。。。。。");
		// one-time initialization code
	}

	public static void oneTimeTearDown() {
		System.out.println("关闭数据库连接。。。。。。。。。。");
		// one-time cleanup code
	}

	protected void setUp() {
		System.out.println("--------------------------------------------");
		System.out.println("1:void setUp");
		expectedWheels = 6;
		myCar = new Car();
	}

	public void testHaha() {
		System.out.println("1:testHaha  测试通过");
	}

	public void testHaha2() {
		System.out.println("2:testHaha2  测试通过");
	}
	
	public int testHaha3() {
		System.out.println("3:testHaha3  测试通过");
		
		return 0;
	}
	
	/*public void test(){
		System.out.println("4:test  测试通过");
	}*/

	protected void tearDown() {//todo
		System.out.println("tearDown");
	}

}
