package com.dsa.sorting_2_1;

public class BubbleSort {

	//In one round we are placing the largest element at the end of the array
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for(int i = 0;i < n-1;i++) {
			for(int j = 1; j< n-i;j++) {
				if(arr[j] < arr[j-1]) {
					int temp = arr[j-1];
					arr[j-1]= arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int v[] = new int[1000000];
		int n = v.length;
		for(int i = 0; i< n ; i++) {
			v[i] = n-i;
		}
		
		BubbleSort obj = new BubbleSort();
		obj.bubbleSort(v);
		for(int i : v) {
			System.out.print(i+" ");
		}
	}
}
