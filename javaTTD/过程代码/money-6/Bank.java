package com.ttd.test;

import java.util.Hashtable;

public class Bank {
	private Hashtable rates = new Hashtable();
	
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
		
//		return source.reduce(to);
		
		return source.reduce(this,to);
	}
	
	//查找汇率
	int rate(String from ,String to){
//		return from.equals("CHF") && to.equals("USD") ? 2:1;
		
/*		Integer rate = (Integer)rates.get(new Pair(from,to));
		return rate.intValue();*/
		
		if(from.equals(to)){
			return 1;
		}
		
		Integer rate = (Integer)rates.get(new Pair(from,to));
		return rate.intValue();
	}
	
	//添加汇率
	void addRate(String from,String to,int rate){
		rates.put(new Pair(from,to), rate);
	}
}
