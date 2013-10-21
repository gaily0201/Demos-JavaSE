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
		
//		System.out.println("augend:"+((Money)augend).amount);
//		System.out.println("augend:"+((Money)addend).amount);
	}
	
	public Money reduce(Bank bank,String to){
		/*int amount = augend.amount+addend.amount;
		return new Money(amount,to);*/
		System.out.println("Sum->reduce@@");
		int a1 = augend.reduce(bank, to).amount;
		
		System.out.println("a1:"+a1);
		System.out.println("<");
		int a2 = addend.reduce(bank, to).amount;
		System.out.println(">");
		
		System.out.println("addend.amount:"+a2);
		
		/*int amount = augend.reduce(bank, to).amount
					+ addend.reduce(bank, to).amount;*/
		
		int amount = a1+a2;
		return new Money(amount,to);
	}
	
	//ПајУ
	public Expression plus(Expression addend) {
//		return null;
		return new Sum(this,addend);
	}
	
	//ПаіЛ
	public Expression times(int multiplier){
		return new Sum(augend.times(multiplier),addend.times(multiplier));
	}
}
