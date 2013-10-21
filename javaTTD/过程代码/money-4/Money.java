package com.ttd.test;

public class Money implements Expression{
	protected int amount;
	protected String currency;
	
/*	static Dollar dollar(int amount,String currency){
		return new Dollar(amount,currency);
	}
	
	static Franc franc(int amount,String currency){
		return new Franc(amount,currency);
	}*/
	
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
	
/*	//货币乘法方法
	Money times(int multiplier){
		return new Money(amount*multiplier,this.currency);
	}*/
	
	//货币乘法方法
	Expression times(int multiplier){
		return new Money(amount*multiplier,this.currency);
	}
	
	
/*	//货币加法方法
	Expression plus(Money addend){
//		return new Money(this.amount+addend.amount,this.currency);
		return new Sum(this,addend);
	}*/
	
	//货币加法方法
	public Expression plus(Expression addend){
//		return new Money(this.amount+addend.amount,this.currency);
		return new Sum(this,addend);
	}
	
	public Money reduce(Bank bank,String to){
//		return this;
		
/*		int rate = currency.equals("CHF") && to.equals("USD") ? 2:1;
		return new Money(amount/rate,to);*/
		
		int rate = bank.rate(currency, to);
		return new Money(amount/rate,to);
	}
	
	public boolean equals(Object object){
		Money money = (Money)object;
		/*return this.amount==money.amount 
			   && this.getClass().equals(money.getClass());*/
		
		return this.amount==money.amount 
		   && currency().equals(money.currency());
	}
	
	String currency(){
		return currency;
	}
	
	@Override
	public String toString() {
		return amount+" "+currency;
	}
}
