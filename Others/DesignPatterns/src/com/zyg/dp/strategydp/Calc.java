package com.zyg.dp.strategydp;

public class Calc {
	public String oper(float a,float b,char c){
		float add=a+b;
		float jian=a-b;
		float cheng=a*b;
		float chu=a/b;
		
		switch(c){
		case '+':
			return "��ӵĽ��Ϊ��"+add;
		case '-':
			return "����Ľ��Ϊ��"+jian;
		case '*':
			return "��˵Ľ��Ϊ��"+cheng;
		case '/':
			return "����Ľ��Ϊ��"+chu;
		default :
			return "������";
		}
		
	}
}
