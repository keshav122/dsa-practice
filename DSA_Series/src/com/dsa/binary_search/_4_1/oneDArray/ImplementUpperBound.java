package com.dsa.binary_search._4_1.oneDArray;

public class ImplementUpperBound {

	public static int upperBound(int[] arr, int x, int n) {
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == x) {
				int i = mid;
				while (i < n && arr[i] == x) {
					i++;
				}
				return i;
			} else if (arr[mid] > x) {
				if (mid == 0) {
					return 0;
				} else if (mid > 0 && arr[mid - 1] <= x) {
					return mid;
				}
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return n;
	}
	
	public static int upperBound_Optimal(int[] arr, int n, int x) {
		int ans = n;
		int low = 0;
		int high = n-1;
		while(low <= high) {
		  int mid = (low + high)/2;
		  if(arr[mid] > x) {
			  ans = mid;
			  high = mid-1;
		  }else {
			  low = mid + 1;
		  }
		}
		return ans;
	}
}
