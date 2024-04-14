package com.dsa.arrays_3_3_hard;

import java.util.Arrays;

public class MergeTwoSortedArraysWithoutExtraSpace {

	public static void mergeTwoSortedArraysWithoutExtraSpace(long[] a, long[] b) {
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] > b[j]) {
				long temp = a[i];
				a[i] = b[j];
				int k = j + 1;
				while (k < b.length && b[k] < temp) {
					b[k - 1] = b[k];
					k++;
				}
				b[k - 1] = temp;
			}
			i++;
		}
	}

	public static void mergeTwoSortedArraysWithoutExtraSpace_Optimal(long[] a, long[] b) {
		int n = a.length;
		int m = b.length;
		int left = n - 1;
		int right = 0;
		while (left >= 0 && right < m) {
			if (a[left] > b[right]) {
				long temp = a[left];
				a[left] = b[right];
				b[right] = temp;
				left--;
				right++;
			} else {
				break;
			}
		}
		Arrays.sort(a);
		Arrays.sort(b);

	}

	
	//The concept comes from the Shell sort technique
	public static void mergeTwoSortedArraysWithoutExtraSpace_OptimalUsingGapMethod(long[] a, long[] b) {
		int n = a.length;
		int m = b.length; 
		int len = n+m;
		int gap = (len/2) + (len % 2);
		while(gap > 0) {
			int left = 0;
			int right = left + gap;
			while(right < len) {
				//both are in different arrays
				if(left < n && right >=n) {
					swapIfGreater(a, b, left, right-n);
				}
				//comparing arr2 elements
				else if(left >= n) {
					swapIfGreater(b, b, left-n, right-n);
				}
				//comparing arr1 elements
				else {
					swapIfGreater(a, a, left, right);
				}
				left++;
				right++;
			}
			if(gap == 1) break;
			gap = (gap/2) + (gap % 2);
		}
	}

	static void swapIfGreater(long[] a, long[] b,int index1 , int index2) {
		if(a[index1] > b[index2]) {
			long temp = a[index1];
			a[index1] = b[index2];
			b[index2] = temp;
		}
	}
	
	
	public static void main(String[] args) {
		long a[] = { 1, 8, 8 };
		long b[] = { 2, 3, 4, 5 };
		mergeTwoSortedArraysWithoutExtraSpace_OptimalUsingGapMethod(a, b);
		for (long i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (long i : b) {
			System.out.print(i + " ");
		}
	}
}
