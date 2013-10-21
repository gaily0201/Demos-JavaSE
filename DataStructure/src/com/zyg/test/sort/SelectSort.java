package com.zyg.test.sort;

public class SelectSort {
	public static void main(String[] args) {
		int[] array = {23,10,7,12,5,1};
		System.out.print("����ǰ��");
		printArray(array);

		selectAscSort(array);
		selectDescSort(array);
	}
	
	/**
	 * ѡ����������
	 * @param array
	 */
	public static void selectAscSort(int[] array){
		int length = array.length;
		int min = array[0];
		int minIdx = 0;
		for(int i=0;i<length-1;i++){
			for(int j=i+1;j<length;j++){
				if(array[j]<min){//���ȽϷ��Ÿ�Ϊ>���ǽ��������㷨
					min = array[j];
					minIdx = j;
				}
			}
			array[minIdx]= array[i];
			array[i] = min;
			//����min��minIdxֵ
			min = array[i+1];
			minIdx = i+1;
		}
		
		System.out.println();
		System.out.print("���������");
		printArray(array);
	}
	
	/**
	 * ѡ��������
	 * @param array
	 */
	public static void selectDescSort(int[] array){
		int length = array.length;
		int max = array[0];
		int maxIdx = 0;
		for(int i=0;i<length-1;i++){
			for(int j=i;j<length;j++){
				if(array[j]>max){//���ȽϷ��Ÿ�Ϊ<�������������㷨
					max = array[j];
					maxIdx = j;
				}
			}
			array[maxIdx]= array[i];
			array[i] = max;
			//����max��maxIdxֵ
			max = array[i+1];
			maxIdx = i+1;
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
