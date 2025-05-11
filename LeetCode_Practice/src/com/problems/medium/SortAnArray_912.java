/*Author: keshav122 */
package com.problems.medium;

import java.util.Arrays;

public class SortAnArray_912 {

	public int[] sortArray_nativeJavaAPI(int[] nums) {
		Arrays.sort(nums);
		return nums;
	}

	public int[] sortArray_InsertionSort(int[] nums) {
		int n = nums.length;
		for (int i = 1; i < n; i++) {
			int val = nums[i];
			int j = i - 1;
			while (j >= 0 && val < nums[j]) {
				nums[j + 1] = nums[j];
				j--;
			}
			nums[j + 1] = val;
		}
		return nums;
	}

	public int[] sortArray_BubbleSort(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		return nums;
	}

	public int[] sortArray_SelectionSort(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			int minVal = nums[i];
			int minIndex = i;

			for (int j = i + 1; j < n; j++) {
				if (nums[j] < minVal) {
					minVal = nums[j];
					minIndex = j;
				}
			}
			if (i != minIndex) {
				nums[minIndex] = nums[i];
				nums[i] = minVal;
			}
		}
		return nums;
	}

	public int[] sortArray_MergeSort(int[] nums) {
		int n = nums.length;
		return mergeSort(nums, 0, n - 1);
	}

	private int[] mergeSort(int[] nums, int sI, int eI) {
		if (sI >= eI) {
			return nums;
		}
		int mid = (sI + eI) / 2;
		mergeSort(nums, sI, mid);
		mergeSort(nums, mid + 1, eI);
		mergeTwoSortedArrays(nums, sI, mid, eI);
		return nums;
	}

	private void mergeTwoSortedArrays(int[] nums, int sI, int mid, int eI) {
		int temp[] = new int[eI - sI + 1];
		int i = sI;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= eI) {
			if (nums[i] <= nums[j]) {
				temp[k] = nums[i];
				i++;
			} else {
				temp[k] = nums[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			temp[k] = nums[i];
			i++;
			k++;
		}
		while (j <= eI) {
			temp[k] = nums[j];
			j++;
			k++;
		}

		for (i = sI; i <= eI; i++) {
			nums[i] = temp[i - sI];
		}
	}

	public static void main(String[] args) {
		int[] a = { 5, 2, 3, 1 };
		SortAnArray_912 obj = new SortAnArray_912();
		int[] ans = obj.sortArray_MergeSort(a);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
}