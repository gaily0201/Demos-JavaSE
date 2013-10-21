package com.ttd.test;

public class Money {
	protected int amount;
	protected String currency;
	
/*	static Dollar dollar(int amount,String currency){
		return new Dollar(amount,currency);
	}
	
	static Franc franc(int amount,String currency){
		return new Franc(amount,currency);
	}*/
	
	static Money dollar(int amount,String currency){
		return new Money(amount,currency);
	}
	
	static Money franc(int amount,String currency){
		return new Money(amount,currency);
	}
	
	Money(int amount,String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public boolean equals(Object object){
		Money money = (Money)object;
		/*return this.amount==money.amount 
			   && this.getClass().equals(money.getClass());*/
		
		return this.amount==money.amount 
		   && currency().equals(money.currency());
	}
	
	Money times(int multiplier){
		return new Money(amount*multiplier,this.currency);
	}
	
	String currency(){
		return currency;
	}
	
	@Override
	public String toString() {
		return amount+" "+currency;
	}
}
