package com.cn;

public class test3 {

	public static void main(String[] args) {
		//��Χ[]:һ���йҺű�ʾƥ��һ���ַ�
		System.out.println("a".matches("[abc]")); /*�Ƿ�ƥ��abc�е��κ�һ��*/
		System.out.println("a".matches("[^abc]"));/*^abc��ʽ����abc�������ַ�*/
		System.out.println("111111111111111111111111111111111111111111111111");
		
		System.out.println("A".matches("[a-zA-Z]")); /*ƥ��Сд��a��z�����Ǵ�д��A��Z*/
		System.out.println("A".matches("[a-z]|[A-Z]"));/*�������һ����*/
		System.out.println("2222222222222222222222222222222222222222222222222");
		
		System.out.println("A".matches("[a-z[A-Z]]"));/*�������һ������˼��д����ͬ����*/
		System.out.println("R".matches("[A-Z&&[RFG]]")); /*��ʾA��Z������RFG������֮һ��*/
		

	}

}
