package com.zyg.test.sort;
//���ͣ�http://blog.csdn.net/m_changgong
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {10,5,7,12};
		System.out.print("����ǰ��");
		printArray(array);

		bubbleAscSort(array);
		bubbleDescSort(array);
	}
	
	/**
	 * ð����������
	 * @param array
	 */
	public static void bubbleAscSort(int[] array){
		int length = array.length;
		int temp=0;
		for(int i=0;i<length-1;i++){
			for(int j=0;j<length-i-1;j++){
				if(array[j+1]<array[j]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		
		System.out.println();
		System.out.print("���������");
		printArray(array);
	}
	
	/**
	 * ð�ݽ�������
	 * @param array
	 */
	public static void bubbleDescSort(int[] array){
		int length = array.length;
		int temp=0;
		for(int i=0;i<length-1;i++){
			for(int j=0;j<length-i-1;j++){
				if(array[j+1]>array[j]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
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
