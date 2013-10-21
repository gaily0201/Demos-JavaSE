package com.zyg.test.sort;

public class SortTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,4,1,5,6,9,7,8,2};
		
		display(a);
		System.out.println();
		//a = bubbleSort(a);
		a = selecitonSort(a);
		display(a);
	}
	
	public static void display(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
			if(i!=a.length-1){
				System.out.print(",");
			}
		}
		
	}
	
	public static int[] bubbleSort(int[] a) {   
		  for (int i = 0; i < a.length; i++) {   
		    for (int j = 0; j < (a.length - i) - 1; j++) {   
		      if (a[j] > a[j + 1]) {   
		        int temp = a[j];   
		        a[j] = a[j + 1];   
		        a[j + 1] = temp;   
		      }   
		    }   
		  }   
		  return a;   
		}  
	
	public static int[] selecitonSort(int[] a) {   
		  for (int i = 0; i < a.length; i++) {   
		    int max = a[0];   
		    int count = 0;   
		    int k = a.length - i - 1;   
		    for (int j = 0; j < a.length - i; j++) {   
		      if (max < a[j]) {   
		        max = a[j];   
		        count = j;   
		      }   
		    }   
		    a[count] = a[k];   
		    a[k] = max;   
		  }   
		  return a;   
		}  
	
	public static int[] insertionSort(int[] a) {   
		   int n = a.length;   
		   for (int i = 1; i < n; i++) {   
		     int temp = a[i];   
		     int j;   
		     for (j = i - 1; j >= 0 && temp < a[j]; j--) {   
		       a[j + 1] = a[j];   
		     }   
		     a[j + 1] = temp;   
		   }   
		   return a;   
		 }  
}
