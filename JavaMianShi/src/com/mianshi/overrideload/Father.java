package com.mianshi.overrideload;

public class Father {
	
	public String say (){
		String mess = null;
		
		mess = "my son!";
		
		return mess;
	}
	
	private void eat(){
		System.out.println("father is eating good food!");
	}
}
