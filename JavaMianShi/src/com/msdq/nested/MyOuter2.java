package com.msdq.nested;

/**
33、	内部类可以引用它的包含类的成员吗？有没有什么限制？ 
完全可以。如果不是静态内部类，那没有什么限制！ 
如果你把静态嵌套类当作内部类的一种特例，
那在这种情况下不可以访问外部类的普通成员变量，
而只能访问外部类中的静态成员，例如，下面的代码：
 */
//静态内部类
public class MyOuter2 {
	static int x;
	public static class Inner{
		public void test(){
			System.out.println(x);
		}
	}
}
