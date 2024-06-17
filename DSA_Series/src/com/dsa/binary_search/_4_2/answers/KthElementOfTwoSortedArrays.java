package com.dsa.binary_search._4_2.answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthElementOfTwoSortedArrays {

	public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
		int[] res = new int[n + m];
		int i = 0;
		while (i < m) {
			res[i] = row1[i];
			i++;
		}
		int j = 0;
		while (i < res.length && j < n) {
			res[i] = row2[j];
			i++;
			j++;
		}
		Arrays.sort(res);
		return res[k - 1];
	}

	public static int ninjaAndLadoos_Better(int row1[], int row2[], int m, int n, int k) {
		int count = 0;
		int i = 0;
		int j = 0;
		while (i < m && j < n) {
			if (row1[i] <= row2[j]) {
				count++;
				if (count == k) {
					return row1[i];
				}
				i++;
			} else {
				count++;
				if (count == k) {
					return row2[j];
				}
				j++;
			}
		}

		while (i < m) {
			count++;
			if (count == k) {
				return row1[i];
			}
			i++;
		}

		while (j < n) {
			count++;
			if (count == k) {
				return row2[j];
			}
			j++;
		}
		return 0;

	}

	public static int ninjaAndLadoos_OptimalBS(int row1[], int row2[], int m, int n, int k) {
		int low = Math.max(0, k - n);
		int high = Math.min(k, m);
		if(m > n) return ninjaAndLadoos_OptimalBS(row2,row1,n,m,k);
		while (low <= high) {
			int mid1 = (low + high) >> 1;
			int mid2 = k - mid1;
			int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
			if (mid1 < m)
				r1 = row1[mid1];
			if (mid2 < n)
				r2 = row2[mid2];
			if (mid1 >= 1)
				l1 = row1[mid1 - 1];
			if (mid2 >= 1)
				l2 = row2[mid2 - 1];
			if (l1 <= r2 && l2 <= r1)
				return Math.max(l1, l2);
			else if (l1 > r2)
				high = mid1 - 1;
			else
				low = mid1 + 1;
		}
		return 0;
	}

	public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
		int low = Math.max(0, k - m);
		int high = Math.min(k, n);
		if(n > m) return kthElement(arr2,arr1,m,n,k);
		while (low <= high) {
			int mid1 = (low + high) >> 1;
			int mid2 = k - mid1;
			int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
			if (mid1 < n)
				r1 = arr1.get(mid1);
			if (mid2 < m)
				r2 = arr2.get(mid2);
			if (mid1 >= 1)
				l1 = arr1.get(mid1 - 1);
			if (mid2 >= 1)
				l2 = arr2.get(mid2 - 1);
			if (l1 <= r2 && l2 <= r1)
				return Math.max(l1, l2);
			else if (l1 > r2)
				high = mid1 - 1;
			else
				low = mid1 + 1;
		}
		return 0;
    }
	public static void main(String[] args) {

		//5
		//23 34 234 235 2311
		//4
		//2 4 6 8
		//4
		int n = 5;
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.addAll(List.of(23,34,234,235,2311));
		int m = 4;
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr1.addAll(List.of(2,4,6,8));
		int k = 4;
		System.out.println(kthElement(arr1, arr2, n, m, k));
	}
}
