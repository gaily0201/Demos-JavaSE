package com.msdq.code;

import java.util.Arrays;

public class PailieZuHe {
	public static void main(String[] args){
		String str = "12345";
		PLZH(str);
	}
	
	public static void PLZH(String str){
		char[] cArr1 = str.toCharArray();
		char[] cArr2 = Arrays.copyOf(cArr1, cArr1.length);
		for(int i=0;i<cArr1.length;i++){
			for(int j=0;j<cArr2.length;j++){
				System.out.println("["+cArr1[i]+","+cArr2[j]+"]");
			}
		}
	}
}
