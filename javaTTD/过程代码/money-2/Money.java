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
	
	//���ҳ˷�����
	Money times(int multiplier){
		return new Money(amount*multiplier,this.currency);
	}
	
	//���Ҽӷ�����
	Expression plus(Money addend){
//		return new Money(this.amount+addend.amount,this.currency);
		return new Sum(this,addend);
	}
	
	public Money reduce(String to){
		return this;
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
