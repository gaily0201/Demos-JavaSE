package com.ttd.test;

public class Sum implements Expression{
/*	Money augend;
	Money addend;*/
	
	Expression augend;
	Expression addend;
	
/*	Sum(Money augend,Money addend){
		this.augend = augend;
		this.addend = addend;
	}*/
	
	Sum(Expression augend,Expression addend){
		this.augend = augend;
		this.addend = addend;
	}
	
	public Money reduce(Bank bank,String to){
		/*int amount = augend.amount+addend.amount;
		return new Money(amount,to);*/
		
		int amount = augend.reduce(bank, to).amount
					+ addend.reduce(bank, to).amount;
		
		return new Money(amount,to);
	}
	
	public Expression plus(Expression addend) {
		return null;
	}
}
