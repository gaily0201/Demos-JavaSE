package com.zyg.junit.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestAll extends TestCase{
	
	public static Test suite(){
		
		TestSuite suite = new TestSuite();
//		suite.addTestSuite(CalculatorTest.class);
//		suite.addTestSuite(LargestTest.class);
		
//		suite.addTest(new TestCar());
		
		suite.addTestSuite(TestCar.class);
		
		return suite;
		
		/*TestSuite suite2 = new TestSuite();
		suite2.addTest(suite);
		
		return suite2;*/
	}
}
