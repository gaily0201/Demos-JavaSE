package com.ttd.test;

public class Money extends Expression{
	protected int amount;
	protected String currency;
	
	static Money dollar(int amount){
		return new Money(amount,"USD");
	}
	
	static Money franc(int amount){
		return new Money(amount,"CHF");
	}
	
	Money(int amount,String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	//ÊµÏÖ³Ë·¨
	public Expression times(int multiplier){
		return new Money(amount*multiplier,this.currency);
	}
	
	public Money reduce(Bank bank,String to){
		
		System.out.println("^^^^^^^^^^^^^^^");
		System.out.println("Money.reduce-> amount:"+amount);
		
		int rate = bank.rate(currency, to);
		return new Money(amount/rate,to);
	}
	
	public boolean equals(Object object){
		Money money = (Money)object;
		return this.amount==money.amount 
		   && currency().equals(money.currency());
	}
	
	String currency(){
		return currency;
	}
	
	@Override
	public String toString() {
		return amount+":"+currency;
	}
}
