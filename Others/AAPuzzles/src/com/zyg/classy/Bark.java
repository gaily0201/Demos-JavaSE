package com.zyg.classy;

public class Bark {
	public static void main(String args[]) {
		Dog1 woofer = new Dog1();
		Dog1 nipper = new Basenji();
		woofer.bark();
		nipper.bark();
	}
}

class Dog1 {
	public static void bark() {
		System.out.print("woof ");
	}
}

class Basenji extends Dog1 {
	public static void bark() {
	}
}

//���� �� static ȥ������̬�����ǲ��ܱ���д��