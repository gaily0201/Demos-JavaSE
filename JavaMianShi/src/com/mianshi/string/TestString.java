package com.mianshi.string;

public class TestString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test();
		System.out.println("����2-------------------");
		
		test2();
	}

	public static void test() {

		//�����������һ�������˶��ٸ�����String s="a"+"b"+"c"+"d";

		String s1 = "a";
		String s2 = s1 + "b";
		String s3 = "a" + "b";

		System.out.println(s2 == "ab");
		System.out.println(s3 == "ab");

		String s = "a" + "b" + "c" + "d";
		System.out.println(s == "abcd");

	}

	public static void test2() {

		//�����������һ�������˶��ٸ�����String s="a"+"b"+"c"+"d";

		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1.equals(s2)); // 1   
		System.out.println(s1 == s2); // 2  

	}

}
