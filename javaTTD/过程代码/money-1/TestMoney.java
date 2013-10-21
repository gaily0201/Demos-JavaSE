package com.ttd.test;

import junit.framework.TestCase;

public class TestMoney extends TestCase {
	private String USD = "USD";
	private String CHF = "CHF";
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	//测试美元
	public void testMultiplication(){
//		Dollar five = new Dollar(5);
		Money five = Money.dollar(5,USD);
		
//		Dollar product = five.times(2);
//		assertEquals(10, product.amount);
//		assertEquals(new Dollar(10), product);
		
//		assertEquals(new Dollar(10), five.times(2));
		assertEquals(Money.dollar(10,USD), five.times(2));
		
//		product = five.times(3);
//		assertEquals(15, product.amount);
		
//		assertEquals(new Dollar(15), five.times(3));
		assertEquals(Money.dollar(15,USD), five.times(3));
		
	}
	
	//测试相等
	public void testEquality(){
/*		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertFalse(new Dollar(5).equals(new Dollar(6)));
		
		assertTrue(new Franc(5).equals(new Franc(5)));
		assertFalse(new Franc(5).equals(new Franc(6)));
		//比较Dollar Franc
		assertFalse(new Franc(5).equals(new Dollar(5)));*/
		
		assertTrue(Money.dollar(5,USD).equals(Money.dollar(5,USD)));
		assertFalse(Money.dollar(5,USD).equals(Money.dollar(6,USD)));
/*		
		assertTrue(Money.franc(5,CHF).equals(Money.franc(5,CHF)));
		assertFalse(Money.franc(5,CHF).equals(Money.franc(6,CHF)));*/
		//比较Dollar Franc
		assertFalse(Money.franc(5,CHF).equals(Money.dollar(5,USD)));
	}
	
	//测试法郎
	public void testFrancMultiplication(){
		/*Franc five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));*/
		
		Money five = Money.franc(5,CHF);
		assertEquals(Money.franc(10,CHF), five.times(2));
		assertEquals(Money.franc(15,CHF), five.times(3));
	}
	
	//测试货币
	public void testCurrency(){
		assertEquals("USD",Money.dollar(1,USD).currency());
		assertEquals("CHF",Money.franc(1,CHF).currency());
	}
	
	//测试不同
	/*public void testDiffrent(){
		assertTrue(new Money(10,CHF).equals(new Franc(10,CHF)));
	}*/
}
