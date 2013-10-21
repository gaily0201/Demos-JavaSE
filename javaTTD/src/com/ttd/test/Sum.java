package com.ttd.test;

public class Sum extends Expression{
	Expression augend;
	Expression addend;
	
	Sum(Expression augend,Expression addend){
		this.augend = augend;
		this.addend = addend;
	}
	
	public Money reduce(Bank bank,String to){
		System.out.println("Sum->reduce@@");
		int a1 = augend.reduce(bank, to).amount;
		
		System.out.println("a1:"+a1);
		System.out.println("<<");
		int a2 = addend.reduce(bank, to).amount;
		System.out.println(">>");
		
		System.out.println("addend.amount:"+a2);
		int amount = a1+a2;
		return new Money(amount,to);
	}
	
	//ÊµÏÖ³Ë·¨
	public Expression times(int multiplier){
		return new Sum(augend.times(multiplier),addend.times(multiplier));
	}
}
