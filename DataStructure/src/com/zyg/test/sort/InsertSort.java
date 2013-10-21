package com.zyg.test.sort;

public class InsertSort {
	public static void main(String[] args) {
		int[] array = {2,3,1,8,6};
		System.out.print("����ǰ��");
		printArray(array);

		insertAscSort(array);
		insertDescSort(array);
	}
	
	/**
	 * ������������
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
		System.out.print("���������");
		printArray(array);
	}
	
	/**
	 * ���뽵������
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
		System.out.print("���������");
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
