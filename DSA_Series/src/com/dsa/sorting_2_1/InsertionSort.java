package com.dsa.sorting_2_1;

public class InsertionSort {

	// Divide the array into two parts sorted and unsorted
	// Bring one element from the unsorted region into the sorted region
	public static void insertionSort(int[] arr, int size) {
		for (int j = 1; j < size; j++) {
			int k = j;
			while (k > 0) {
				if (arr[k] < arr[k - 1]) {
					int temp = arr[k - 1];
					arr[k - 1] = arr[k];
					arr[k] = temp;
					k--;
				} else {
					break;
				}
			}

		}
	}

	public static void insertionSort_Way2(int[] arr, int size) {
		for (int j = 1; j < size; j++) {
			int k = j - 1;
			int temp = arr[j];
			while (k >= 0 && arr[k] > temp) {
				arr[k + 1] = arr[k];
				k--;
			}
			arr[k + 1] = temp;
		}
	}

	public static void main(String[] args) {
		int[] v = { 3, 1 };
		InsertionSort obj = new InsertionSort();
		obj.insertionSort_Way2(v, v.length);
		for (int i : v) {
			System.out.print(i + " ");
		}
	}
}
