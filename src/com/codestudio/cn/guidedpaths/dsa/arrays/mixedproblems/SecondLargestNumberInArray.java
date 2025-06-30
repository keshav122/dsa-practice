package com.codestudio.cn.guidedpaths.dsa.arrays.mixedproblems;

import java.util.Arrays;

public class SecondLargestNumberInArray {

	//check this not working
	public static int findSecondLargest(int n, int[] arr) {
		int largest = arr[0], secondLargest = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			if (arr[i] > largest) {
				largest = arr[i];
				secondLargest = largest;
			} else if (arr[i] < largest && arr[i] > secondLargest) {
				secondLargest = arr[i];
			}
		}

		if (secondLargest != Integer.MIN_VALUE) {
			return secondLargest;
		} else {
			return -1;
		}

	}

	public static int findSecondLargestV2(int n, int[] arr) {
		Arrays.sort(arr);
		int largest = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] < largest) {
				return arr[i];
			}
		}
      return -1;
	}
}
