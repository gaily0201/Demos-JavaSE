package com.buildxml.area.utils;

public class GetPackageNameTest {
	public static void main(String[] args){
		System.out.println(GetPackageNameTest.class.getResource("/"));
		System.out.println(GetPackageNameTest.class.getResource(""));
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(GetPackageNameTest.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));
		
		System.out.println(GetPackageNameTest.class.getPackage());
		System.out.println(GetPackageNameTest.class.getName());
	}
}
