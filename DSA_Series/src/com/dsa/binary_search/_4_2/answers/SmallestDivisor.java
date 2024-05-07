package com.dsa.binary_search._4_2.answers;

public class SmallestDivisor {

	public static int smallestDivisor(int arr[], int limit) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		for (int i = 1; i <= max; i++) {
			int sum = 0;
			for (int a : arr) {
				if (a % i == 0) {
					sum += (a / i);
				} else {
					sum += ((a / i) + 1);
				}

			}
			if (sum <= limit) {
				return i;
			}
		}
		return -1;
	}
	
	public static int smallestDivisor1(int arr[], int limit) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int low = 1;
		int high = max;
		int smallDiv = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = (low + high)/2;
			int sum = 0;
			for (int a : arr) {
				if (a % mid == 0) {
					sum += (a / mid);
				} else {
					sum += ((a / mid) + 1);
				}

			}
			if (sum <= limit) {
				smallDiv = Math.min(smallDiv, mid);
				high = mid-1;
			}else {
				low = mid + 1;
			}
		}
		return smallDiv;
	}
}
