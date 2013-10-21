package com.msdq.code;

/*��дһ��������һ��ʮ�����������ַ�������ת�����������ء�*/
public class Convert {
	public static void main(String[] args){
		Convert c = new Convert();
		String str16Hex = "000F";
		
		long sum = c.str16HexToDigit(str16Hex);
		System.out.println(str16Hex+"->(16����):"+sum);
		
		//ʹ��Integer��ʵ��
		long sum2 = Integer.parseInt(str16Hex, 16);
		System.out.println(str16Hex+"->(16����):"+sum2);
	}
	
	public long str16HexToDigit(String str16Hex){
		int len = str16Hex.length();
		long sum = 0;
		for(int i=0;i<len;i++){
			char c = (char)str16Hex.charAt(len-1-i);
			int n = Character.digit(c, 16);
			//System.out.println(1<<(4*i));
			sum += n*(1<<(4*i));
		}
		return sum;
	}
}
