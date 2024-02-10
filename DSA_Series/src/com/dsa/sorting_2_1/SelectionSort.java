package com.dsa.sorting_2_1;

public class SelectionSort {

	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			// In each round we place one element at its correct position
			int minVal = arr[i];
			int minIndex = i;
			for (int j = i; j < n; j++) {
				if (arr[j] <= minVal) {
					minVal = arr[j];
					minIndex = j;
				}
			}
			if (i != minIndex) {
				int temp = arr[i];
				arr[i] = minVal;
				arr[minIndex] = temp;
			}
		}
	}

	public static void selectionSort_Improved(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			// In each round we place one element at its correct position
			int minVal = arr[i];
			int minIndex = i;
			// Iterate from i+ 1
			for (int j = i + 1; j < n; j++) {
				if (arr[j] <= minVal) {
					minVal = arr[j];
					minIndex = j;
				}
			}

			if (i != minIndex) {
				arr[minIndex] = arr[i];
				arr[i] = minVal;
			}
		}
	}

	public static void main(String[] args) {
		int[] v = { 3, 1 };
		SelectionSort obj = new SelectionSort();
		obj.selectionSort_Improved(v);
		for (int i : v) {
			System.out.print(i + " ");
		}
	}

}
