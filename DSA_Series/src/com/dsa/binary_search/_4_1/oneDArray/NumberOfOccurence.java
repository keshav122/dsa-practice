package com.dsa.binary_search._4_1.oneDArray;

public class NumberOfOccurence {

	public static int count(int arr[], int n, int x) {
		int start = 0;
		int end = n - 1;
		boolean isFound = false;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == x) {
				isFound = true;
				int l = mid;
				int r = mid;
				while (l >= 0 && arr[l] == x) {
					l--;
				}
				l += 1;
				while (r < n && arr[r] == x) {
					r++;
				}
				r -= 1;
				if (isFound) {
					return (r - l + 1);
				}
			} else if (arr[mid] > x) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return 0;
	}

	public static int count_Optimal(int arr[], int n, int x) {
		if (lastOcc(arr, n, x) != -1) {
			return (lastOcc(arr, n, x)) - firstOcc(arr, n, x) + 1;
		}
		return 0;
	}

	private static int lastOcc(int[] arr, int n, int x) {
		int low = 0;
		int high = n - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == x) {
				ans = mid;
				low = mid + 1;
			} else if (arr[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static int firstOcc(int[] arr, int n, int x) {
		int low = 0;
		int high = n - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == x) {
				ans = mid;
				high = mid - 1;
			} else if (arr[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
}
