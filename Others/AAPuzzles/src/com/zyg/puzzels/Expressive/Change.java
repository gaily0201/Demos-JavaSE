package com.zyg.puzzels.Expressive;

import java.math.BigDecimal;

public class Change {
	public static void main(String[] args) {
		System.out.println(2.00 - 1.1);
		
		//׾�ӵĽ�����������Ծ���ʹ�ö����Ƹ�����
		System.out.printf("%.2f%n",2.00 - 1.10);
		//����1
		System.out.println((200 - 110) + "cents");
		
		System.out.println(new BigDecimal(.1));
		//����2
		System.out.println(new BigDecimal("2.00").
				subtract(new BigDecimal("1.10")));
	}
}
