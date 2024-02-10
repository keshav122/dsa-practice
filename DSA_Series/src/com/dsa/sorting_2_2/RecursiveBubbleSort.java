package com.dsa.sorting_2_2;

public class RecursiveBubbleSort {

	//Recursive Bubble Sort 
    public static void bubbleSort(int[] arr, int n) {
		bubbleSort(arr,0,n);
    }
	
	 private static void bubbleSort(int[] arr, int i ,int n) {
			if(i == n -1) {
				return;
			}
			bubbleSort(arr,i+1,n);
			while(i < n-1) {
				if(arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
				i++;
			}
		}

	public static void main(String[] args) {
 		int[] v = {41, 467 ,334, 500 ,169 ,724, 478, 358 ,962 ,464};
		RecursiveBubbleSort obj = new RecursiveBubbleSort();
		obj.bubbleSort(v,v.length);
		for(int i : v) {
			System.out.print(i+" ");
		}
	}
}
