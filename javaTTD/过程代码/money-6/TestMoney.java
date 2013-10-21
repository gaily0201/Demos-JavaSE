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
	
	//����ͬһ��������
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
	
	//���Դ���ͬ����
	public void testReduceMoneyDifferentCurrency(){
		Bank bank = new Bank();
		bank.addRate(CHF,USD,2);
		Money result = bank.reduce(Money.franc(2),USD);
		assertEquals(Money.dollar(1),result);
	}
	
	//�����������
	public void testArrayEquals(){
		assertEquals(new Object[]{"abc"},new Object[]{"abc"});
		
	}
	
	//���Ի��Ҷһ�
	public void testIdentityRate(){
		assertEquals(1,new Bank().rate(USD, USD));
	}
	
	//-------------------------------------------------------------------
	//���Ի��һ�����
	public void testMixedAddtion(){
//		Money fiveBucks = Money.dollar(5);
		Expression fiveBucks = Money.dollar(5);
//		Money tenFranks = Money.franc(10);
		Expression tenFranks = Money.franc(10);
		
		Bank bank = new Bank();
		bank.addRate(CHF, USD, 2);
		Money result = bank.reduce(fiveBucks.plus(tenFranks), USD);
		assertEquals(Money.dollar(10),result);
	}
	
	//����sum.plus
	public void testSumPlusMoney(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFranks = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate(CHF, USD, 2);
		
		Expression sum = new Sum(fiveBucks,tenFranks)
						.plus(fiveBucks);
		Money result = bank.reduce(sum, USD);
		assertEquals(Money.dollar(15),result);
	}
	
	//����sum.times
	public void testSumTimes(){
		Expression fiveBucks = Money.dollar(5);
		Expression tenFranks = Money.franc(10);
		Bank bank = new Bank();
		bank.addRate(CHF, USD, 2);
		
		Expression sum = new Sum(fiveBucks,tenFranks).times(5);
		Money result = bank.reduce(sum, USD);
		assertEquals(Money.dollar(50),result);
	}
	
	//������ͬ���ҷ��ض���-- ʧ��
	/*public void testPlusSameCurrencyReturnsMoney(){
		Expression sum = Money.dollar(1).plus(Money.franc(1));
		assertTrue(sum instanceof Money);
	}*/
	
	
	//zyg����sum.plus
	public void testSumPlusMoney_zyg(){
		Expression fiveBucks = Money.dollar(5);
		Expression fourteenFranks = Money.franc(14);
		
		Expression sixBucks = Money.dollar(6);
		
		Bank bank = new Bank();
		bank.addRate(CHF, USD, 2);
		
		Expression sum = new Sum(fiveBucks,fourteenFranks)
						.plus(sixBucks);
		
		System.out.println("-----------------------------");
		Money result = bank.reduce(sum, USD);
	}
}
