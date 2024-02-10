package com.dsa.sorting_2_2;

public class RecursiveInsertionSort {

	 public static void insertionSort(int[] arr, int size) {
		 insertionSort(arr, size,size-1);
	 }
	 
	 private static void insertionSort(int[] arr, int size, int i) {
		if(i == 0) {
			return;
		}
		insertionSort(arr, size, i-1);
		int temp = arr[i];
		int j = i-1;
		while(j >= 0 && temp < arr[j]) {
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = temp;
	}

	public static void main(String[] args) {
		int[] v = {2, 13 ,4 ,1 ,3, 6 ,28};
		insertionSort(v,v.length);
		for(int i : v) {
			System.out.print(i+" ");
		}
	}
}
