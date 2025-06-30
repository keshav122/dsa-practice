package com.codestudio.cn.guidedpaths.dsa.arrays.dutchnationalflagalgorithm;

/*Author: keshav122 */

public class Sort012 {

	public static void sort012(int[] arr) {
		int n = arr.length;
		int low = 0;
		int mid = 0;
		int high = n - 1;
		while (mid <= high) {
			if (arr[mid] == 0) {
				arr[mid] = arr[low];
				arr[low] = 0;
				mid++;
				low++;
			} else if (arr[mid] == 1) {
				mid++;
			} else {
				arr[mid] = arr[high];
				arr[high] = 2;
				// we do not increment mid pointer because now the value placed
				// at mid might be 0 and if we do not handle that it may cause
				// issues
				// take 0 1 2 2 10 as example
				high--;
			}
		}
	}
}
