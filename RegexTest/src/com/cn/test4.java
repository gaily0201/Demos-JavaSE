package com.cn;

public class test4 {

	public static void main(String[] args) {
		// \s:ƥ���κοհ��ַ��������ո��Ʊ������ҳ���ȡ��� [ \f\n\r\t\v] ��Ч
		// \w��ƥ���κ������ַ��������»��ߡ���[A-Za-z0-9_]��Ч��

		System.out.println(" \n\r\t".matches("\\s{4}"));
		System.out.println(" ".matches("\\S")); //��S��ʾ�ǿհ��ַ�
		System.out.println("111111111111111111111111111111111111111111111111");
		
		
		System.out.println("a_8".matches("\\w{3}"));
		System.out.println("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));//[&^#%]+ ��ʾ�Һ����������֮һ����һ�λ���
		System.out.println("2222222222222222222222222222222222222222222222222");
		
		System.out.println("\\".matches("\\\\")); /*java��������\����һ��\ :������ʽҲ������\����һ��\*/

	}

}
