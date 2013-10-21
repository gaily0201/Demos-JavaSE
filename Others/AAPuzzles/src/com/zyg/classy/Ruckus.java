package com.zyg.classy;

public class Ruckus {
	public static void main(String[] args) {
		Dog dogs[] = { new Dog(), new Dog() };
		for (int i = 0; i < dogs.length; i++)
			dogs[i].woof();
		
		Cat cats[] = { new Cat(), new Cat(), new Cat() };
		for (int i = 0; i < cats.length; i++)
			cats[i].meow();
		
		System.out.print(Dog.getCount() + " woofs and ");
		System.out.println(Cat.getCount() + " meows");
	}
}

class Counter {
	private static int count = 0;

	public static final synchronized void increment() {
		count++;
	}

	public static final synchronized int getCount() {
		return count;
	}
}

class Dog extends Counter {
	public Dog() {
	}

	public void woof() {
		increment();
	}
}

class Cat extends Counter {
	public Cat() {
	}

	public void meow() {
		increment();
	}
}

//修改方案：除非必须使用继承，否则请使用组合
/*class Dog {
	private static int woofCounter;

	public Dog() {
	}

	public static int woofCount() {
		return woofCounter;
	};

	public void woof() {
		woofCounter++;
	}
}

class Cat {
	private static int meowCounter;

	public Cat() {
	}

	public static int meowCount() {
		return meowCounter;
	};

	public void meow() {
		meowCounter++;
	}
}
*/