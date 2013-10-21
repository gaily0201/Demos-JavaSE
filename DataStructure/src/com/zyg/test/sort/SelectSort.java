package com.zyg.test.sort;

public class SelectSort {
	public static void main(String[] args) {
		int[] array = {23,10,7,12,5,1};
		System.out.print("排序前；");
		printArray(array);

		selectAscSort(array);
		selectDescSort(array);
	}
	
	/**
	 * 选择升序排序
	 * @param array
	 */
	public static void selectAscSort(int[] array){
		int length = array.length;
		int min = array[0];
		int minIdx = 0;
		for(int i=0;i<length-1;i++){
			for(int j=i+1;j<length;j++){
				if(array[j]<min){//将比较符号改为>即是降序排序算法
					min = array[j];
					minIdx = j;
				}
			}
			array[minIdx]= array[i];
			array[i] = min;
			//重置min、minIdx值
			min = array[i+1];
			minIdx = i+1;
		}
		
		System.out.println();
		System.out.print("升序排序后；");
		printArray(array);
	}
	
	/**
	 * 选择降序排序
	 * @param array
	 */
	public static void selectDescSort(int[] array){
		int length = array.length;
		int max = array[0];
		int maxIdx = 0;
		for(int i=0;i<length-1;i++){
			for(int j=i;j<length;j++){
				if(array[j]>max){//将比较符号改为<即是升序排序算法
					max = array[j];
					maxIdx = j;
				}
			}
			array[maxIdx]= array[i];
			array[i] = max;
			//重置max、maxIdx值
			max = array[i+1];
			maxIdx = i+1;
		}
		
		System.out.println();
		System.out.print("降序排序后；");
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
