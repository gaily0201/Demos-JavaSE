package com.ttd.test;

import junit.framework.TestCase;

public class TestMoney extends TestCase {
	private String USD = "USD";
	private String CHF = "CHF";
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	//������Ԫ
	public void testMultiplication(){
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
	}
	
	//�������
	public void testEquality(){
		//�Ƚ�Dollar Franc
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		//�Ƚ�Dollar Franc
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}
	
	//���Է���
	public void testFrancMultiplication(){
		Money five = Money.franc(5);
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
	}
	
	//���Ի���
	public void testCurrency(){
		assertEquals("USD",Money.dollar(1).currency());
		assertEquals("CHF",Money.franc(1).currency());
	}
	
	//���Լӷ�
	public void testSimpleAddition(){
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum,USD);
		assertEquals(Money.dollar(10),reduced);
	}
	
	//���Լӷ�����ֵ
	public void testPlusReturnsSum(){
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum)result;
		assertEquals(five,sum.augend);
		assertEquals(five,sum.addend);
	}
	
	//���Դ����
	public void testReduceSum(){
		Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum,USD);
		assertEquals(Money.dollar(7),result);
	}
	
	//���Դ���Money
	public void testReduceMoney(){
		Bank bank =  new Bank();
		Money result = bank.reduce(Money.dollar(1), USD);
		assertEquals(Money.dollar(1),result);
	}
}
