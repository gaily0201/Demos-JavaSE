package com.zyg.dp.strategydp;

public class Calc {
	public String oper(float a,float b,char c){
		float add=a+b;
		float jian=a-b;
		float cheng=a*b;
		float chu=a/b;
		
		switch(c){
		case '+':
			return "相加的结果为："+add;
		case '-':
			return "相减的结果为："+jian;
		case '*':
			return "相乘的结果为："+cheng;
		case '/':
			return "相除的结果为："+chu;
		default :
			return "出错啦";
		}
		
	}
}
