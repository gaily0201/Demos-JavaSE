package com.msdq.nested;

public class Outer {
	int out = 0;
	
	public void method(){
		Inner1 inner = new Inner1();
		final int temp = 0;
		class Inner2{//在方法体内部定义的内部类
			
			public void test(){
				System.out.println(temp); //temp必须是final类型才可以访问
			}
		}
	}
	
	public class Inner1{ //方法体外定义内部类
		
	}
}
