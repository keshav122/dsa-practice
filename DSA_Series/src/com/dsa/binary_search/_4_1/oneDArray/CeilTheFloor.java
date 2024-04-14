package com.dsa.binary_search._4_1.oneDArray;

public class CeilTheFloor {

	public static int[] getFloorAndCeil(int[] a, int n, int x) {
		int[] ans = new int[2];
		int index = searchInsert(a, x);
		if (index < n && a[index] == x) {
			ans[0] = x;
			ans[1] = x;
		} else if (index < n && a[index] > x) {
			if (index == 0) {
				ans[0] = -1;
			} else {
				ans[0] = a[index - 1];
			}

			ans[1] = a[index];
		} else {
			if(index >= n) {
				ans[0] = a[n-1];
			}else {
				ans[0] = a[index];
			}

			if (index >= n - 1 ) {
				ans[1] = -1;
			} else {
				ans[1] = a[index + 1];
			}

		}
		return ans;
	}

	public static int searchInsert(int[] arr, int x) {
		int start = 0;
		int n = arr.length;
		int end = n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == x) {
				return mid;
			} else if (arr[mid] > x) {
				if (mid == 0 || (mid > 0 && arr[mid - 1] < x)) {
					return mid;
				}
				end = mid - 1;
			} else {
				if (mid == n - 1) {
					return n;
				} else if (mid < n - 1 && arr[mid + 1] > x) {
					return mid + 1;
				}
				start = mid + 1;
			}
		}
		return 0;
	}
	
	public static int[] getFloorAndCeil_Optimal(int[] a, int n, int x) {
		int ans[] = new int[2];
		ans[0] = floor(a,n,x);
		ans[1] = ceil(a,n,x);
		return ans;
	}
	private static int ceil(int[] a, int n, int x) {
		int low = 0;
		int high = n-1;
		int ans = -1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(a[mid] >= x) {
				ans = a[mid];
				high = mid-1;
			}else {
				low = mid + 1;
			}
			
		}
		return ans;
	}

	private static int floor(int[] a, int n, int x) {
		int low = 0;
		int high = n-1;
		int ans = -1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(a[mid] <= x) {
				ans = a[mid];
				low = mid + 1;
			}else {
				high = mid-1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] a = {3, 4, 4, 7, 8, 10};
		int x = 8;
		int[] res = getFloorAndCeil_Optimal(a, a.length, x);
		for(int i : res) {
			System.out.print(i+" ");
		}
	}

}
