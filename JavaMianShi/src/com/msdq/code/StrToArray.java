package com.msdq.code;

import java.util.StringTokenizer;

/**
 * ��Ŀ����ΰ�һ�ζ��ŷָ���ַ���ת����һ������?
 *
 */
public class StrToArray {

	public static void main(String[] args) {
		String str = "110,120,119,zyg";
		String[] strArray = null;
		
		System.out.println("����convertStrToArray�����");
		strArray = convertStrToArray(str);
		printArray(strArray);
		
		System.out.println("����convertStrToArray2�����");
		strArray = convertStrToArray2(str);
		printArray(strArray);
	}
	
	//ʹ��String��split ����
	public static String[] convertStrToArray(String str){
		String[] strArray = null;
		strArray = str.split(",");
		return strArray;
	}
	
	//ʹ��StringTokenizerʵ��
	//api˵����StringTokenizer �ǳ��ڼ����Ե�ԭ�����������������
	//����Ȼ���´����в�������ʹ����������������Ѱ��˹��ܵ���ʹ��
	//String �� split ������ java.util.regex ��
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
