package com.ttd.test;

public class Bank {
	
	Money reduce(Expression source,String to){
//		return null;
//		return Money.dollar(10);
		
/*		Sum sum = (Sum)source;
		int amount = sum.augend.amount+sum.addend.amount;
		return new Money(amount,to);*/
		
/*		Sum sum = (Sum)source;
		return sum.reduce(to);*/
		
		
/*		if(source instanceof Money){
			return (Money)source;
		}
		
		Sum sum = (Sum)source;
		return sum.reduce(to);*/
		
/*		if(source instanceof Money){
			return ((Money)source).reduce(to);
		}
		
		Sum sum = (Sum)source;
		return sum.reduce(to);*/
		
		return source.reduce(to);
	}
}
