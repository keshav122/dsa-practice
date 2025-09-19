/*Author: keshav122 */
package com.codestudio.cn.guidedpaths.dsa.arrays.searchingandsorting;

public class SearchInRotatedSortedArray {

	public static int search_BruteForce(int arr[], int key) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static int search(int arr[], int key) {
		int pivotIndex = pivotIndex(arr, 0, arr.length - 1);
		if (pivotIndex == -1) {
			return binarySearch(arr, 0, arr.length - 1, key);
		}

		if (arr[pivotIndex] == key) {
			return pivotIndex;
		}
		if (arr[0] <= key) {
			return binarySearch(arr, 0, pivotIndex - 1, key);
		}
		return binarySearch(arr, pivotIndex + 1, arr.length - 1, key);
	}

	private static int binarySearch(int[] arr, int sI, int eI, int key) {
		if (eI < sI) {
			return -1;
		}
		while (sI <= eI) {
			int mid = (sI + eI) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] <= key) {
				sI = mid + 1;
			} else {
				eI = mid - 1;
			}
		}
		return -1;
	}

	private static int pivotIndex(int[] arr, int low, int high) {
		if (high < low) {
			return -1;
		}

		if (high == low) {
			return low;
		}

		int mid = low + (high - low) / 2;
		if (mid < high && arr[mid] > arr[mid + 1]) {
			return mid;
		}
		if (mid > low && arr[mid] < arr[mid - 1]) {
			return mid - 1;
		}
		// If the element at mid is less than low then elements on the left of mid will
		// be greater than mid
		// and we will look for the transition from larger to smaller element in the
		// left region of the mid
		if (arr[low] >= arr[mid]) {
			return pivotIndex(arr, low, mid - 1);
		}
		return pivotIndex(arr, mid + 1, high);
	}
}
