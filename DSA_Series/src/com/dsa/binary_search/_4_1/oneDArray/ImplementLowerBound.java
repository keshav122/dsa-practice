package com.dsa.binary_search._4_1.oneDArray;

public class ImplementLowerBound {

	public static int lowerBound(int[] arr, int n, int x) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == x) {
				int i = mid;
				while (i >= 0 && arr[i] == x) {
					i--;
				}
				return i + 1;
			} else if (arr[mid] > x) {
				if (mid == 0) {
					return 0;
				} else if (arr[mid - 1] < x) {
					return mid;
				}
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return n;
	}
	
	
	public static int lowerBound_Optimal(int[] arr, int n, int x) {
		//Even if we don't find anything we will place the value @ index n
		int ans = n;
		int low = 0;
		int high = n-1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr[mid] >= x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid+1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int a[] = { 1, 1, 1, 1, 1 };
		System.out.println(lowerBound(a, 5, 1));
	}
}
