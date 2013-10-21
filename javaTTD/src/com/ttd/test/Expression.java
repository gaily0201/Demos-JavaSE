package com.ttd.test;

public abstract class Expression {
	protected abstract Money reduce(Bank bank,String to);
	protected abstract Expression times(int multiplier);
	
	public Expression plus(Expression addend){
		return new Sum(this,addend);
	}
}
