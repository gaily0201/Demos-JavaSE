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
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}
	
	//测试相等
	public void testEquality(){
		//比较Dollar Franc
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		//比较Dollar Franc
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}
	
	//测试法郎
	public void testFrancMultiplication(){
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	}
	
	//测试货币
	public void testCurrency(){
		assertEquals("USD",Money.dollar(1).currency());
		assertEquals("CHF",Money.franc(1).currency());
	}
	
	//测试加法
	public void testSimpleAddition(){
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum,USD);
		assertEquals(Money.dollar(10),reduced);
	}
	
	//测试加法返回值
	public void testPlusReturnsSum(){
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum)result;
		assertEquals(five,sum.augend);
		assertEquals(five,sum.addend);
	}
	
	//测试处理和
	public void testReduceSum(){
		Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum,USD);
		assertEquals(Money.dollar(7),result);
	}
	
	//测试处理Money
	public void testReduceMoney(){
		Bank bank =  new Bank();
		Money result = bank.reduce(Money.dollar(1), USD);
		assertEquals(Money.dollar(1),result);
	}
}
