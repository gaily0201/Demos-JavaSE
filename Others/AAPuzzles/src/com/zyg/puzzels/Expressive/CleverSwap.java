package com.zyg.puzzels.Expressive;

public class CleverSwap {
	public static void main(String[] args) {
		int x = 1984; // (0x7c0)
		int y = 2001; // (0x7d1)
		//x^= y^= x^= y;
		//System.out.println("x= " + x + "; y= " + y);
		
		// Java ��x^= y^= x^= y ��ʵ����Ϊ
		/*int tmp1 = x ; // x �ڱ��ʽ�е�һ�γ���
		int tmp2 = y ; // y �ĵ�һ�γ���
		int tmp3 = x ^ y ; // ����x ^ y
		x = tmp3 ; // ���һ����ֵ���洢x ^ y �� x
		y = tmp2 ^ tmp3 ; // �ڶ�����ֵ���洢�����x ֵ��y ��
		x = tmp1 ^ y ; // ��һ����ֵ���洢0 ��x ��
*/		
		// ɱ����ţ����������ǧ��Ҫ��ô����
		y = (x^= (y^= x))^ y ;
		System.out.println("x= " + x + "; y= " + y);
	}

}
