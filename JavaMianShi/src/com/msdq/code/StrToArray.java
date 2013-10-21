package com.msdq.code;

import java.util.StringTokenizer;

/**
 * 题目：如何把一段逗号分割的字符串转换成一个数组?
 *
 */
public class StrToArray {

	public static void main(String[] args) {
		String str = "110,120,119,zyg";
		String[] strArray = null;
		
		System.out.println("调用convertStrToArray结果：");
		strArray = convertStrToArray(str);
		printArray(strArray);
		
		System.out.println("调用convertStrToArray2结果：");
		strArray = convertStrToArray2(str);
		printArray(strArray);
	}
	
	//使用String的split 方法
	public static String[] convertStrToArray(String str){
		String[] strArray = null;
		strArray = str.split(",");
		return strArray;
	}
	
	//使用StringTokenizer实现
	//api说明：StringTokenizer 是出于兼容性的原因而被保留的遗留类
	//（虽然在新代码中并不鼓励使用它）。建议所有寻求此功能的人使用
	//String 的 split 方法或 java.util.regex 包
	public static String[] convertStrToArray2(String str){
		StringTokenizer st = new StringTokenizer(str,",");
		String[] strArray = new String[st.countTokens()];
		int i=0;
		while(st.hasMoreTokens()){
			strArray[i++] = st.nextToken();
		}
		return strArray;
	}
	
	
	public static void printArray(String[] arr){
		int len = arr.length;
		for(int i=0;i<len;i++){
			System.out.println(arr[i]);
		}
	}
}
