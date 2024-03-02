package com.dsa.arrays_3_1_easy;

public class RemoveDuplicatesFromArray {

	public static int removeDuplicates(int[] arr, int n) {
		int slow = 0;
		int fast = 1;
		while (fast < n) {
			if (arr[slow] != arr[fast]) {
				arr[slow + 1] = arr[fast];
				slow++;
			}
			fast++;

		}
		return slow + 1;
	}

	public static int removeDuplicates_Improved(int[] arr, int n) {
		int slow = 0;
		for (int fast = 1; fast < n; fast++) {
			if (arr[fast] != arr[slow]) {
				arr[slow + 1] = arr[fast];
				slow++;
			}
		}
		return slow + 1;
	}

	public static void main(String[] args) {
		int[] v = { 1, 2, 2, 2, 3 };
		System.out.println(removeDuplicates(v, v.length));
	}
}
