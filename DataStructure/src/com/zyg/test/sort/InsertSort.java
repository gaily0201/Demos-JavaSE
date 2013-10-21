package com.zyg.test.sort;

public class InsertSort {
	public static void main(String[] args) {
		int[] array = {2,3,1,8,6};
		System.out.print("ÅÅĞòÇ°£»");
		printArray(array);

		insertAscSort(array);
		insertDescSort(array);
	}
	
	/**
	 * ²åÈëÉıĞòÅÅĞò
	 * @param array
	 */
	public static void insertAscSort(int[] array){
		int length = array.length;
		for(int out = 1;out<length;out++){
			int temp = array[out];
			int in = out;
			while(in>0 && array[in-1]>temp){
				array[in] = array[in-1];
				--in;
			}
			array[in]=temp;
		}
		
		System.out.println();
		System.out.print("ÉıĞòÅÅĞòºó£»");
		printArray(array);
	}
	
	/**
	 * ²åÈë½µĞòÅÅĞò
	 * @param array
	 */
	public static void insertDescSort(int[] array){
		int length = array.length;
		for(int out = 1;out<length;out++){
			int temp = array[out];
			int in = out;
			while(in>0 && array[in-1]<temp){
				array[in] = array[in-1];
				--in;
			}
			array[in]=temp;
		}
		
		System.out.println();
		System.out.print("ÉıĞòÅÅĞòºó£»");
		printArray(array);
	}
	
	public static void printArray(int[] array){
		int length = array.length;
		for(int i=0;i<length;i++){
			System.out.print(array[i]);
			if(i!=length-1){
				System.out.print(",");
			}
		}
	}
}
