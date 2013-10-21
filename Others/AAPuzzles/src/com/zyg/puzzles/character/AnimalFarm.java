package com.zyg.puzzles.character;

public class AnimalFarm {

	public static void main(String[] args) {
		final String pig = "length: 10";
		final String dog = "length: 10" + pig.length();
		System.out.println("pig:"+pig);
		System.out.println("dog:"+dog);
		
		System.out. println("Animals are equal: "
				+ pig == dog);
		//方案1
		/*System.out. println("Animals are equal: "
				+ (pig == dog));*/
		//方案2：
		System.out. println("Animals are equal: "
				+ pig.equals(dog));
		
		final String pig1="pig1";
		final String pig2="pig1";
		
		System.out. println("Animals are equal: "
		+ (pig1 == pig2));
		
		int pig1HashCode = 
			System.identityHashCode(pig1);
		
		int pig2HashCode = 
			System.identityHashCode(pig2);
		
		System.out.println(pig1HashCode);
		System.out.println(pig2HashCode);
	}
}
