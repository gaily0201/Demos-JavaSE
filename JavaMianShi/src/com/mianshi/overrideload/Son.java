package com.mianshi.overrideload;

public class Son extends Father{
	
	public static void main(String[] args){
		Son s = new Son();
		
		System.out.println(s.say());
		s.eat();
	}
	
	@Override
	public String say() {
		String mess = "son";
		return mess;
	}
	
	private void eat(){
		System.out.println("son is eating good food!");
	}
}
