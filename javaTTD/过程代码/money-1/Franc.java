package com.ttd.test;

public class Franc extends Money{
	
	public Franc(int amount,String currency){
		/*this.amount = amount;
		this.currency = currency;*/
		
		super(amount,currency);
	}
	
/*	Money times(int multiplier){
//		return new Franc(amount * multiplier,null);
//		return Money.franc(amount,"CHF");

//		return new Franc(amount*multiplier,this.currency);
		
//		return Money.franc(amount*multiplier,this.currency);
		
		return new Money(amount*multiplier,this.currency);
	}*/
}
