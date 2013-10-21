package com.zyg.puzzels.Expressive;

import java.math.BigDecimal;

public class Change {
	public static void main(String[] args) {
		System.out.println(2.00 - 1.1);
		
		//拙劣的解决方案——仍旧是使用二进制浮点数
		System.out.printf("%.2f%n",2.00 - 1.10);
		//方案1
		System.out.println((200 - 110) + "cents");
		
		System.out.println(new BigDecimal(.1));
		//方案2
		System.out.println(new BigDecimal("2.00").
				subtract(new BigDecimal("1.10")));
	}
}
