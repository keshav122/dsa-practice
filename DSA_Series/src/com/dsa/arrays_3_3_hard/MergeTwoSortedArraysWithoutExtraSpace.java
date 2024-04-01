package com.dsa.arrays_3_3_hard;

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

	public static void main(String[] args) {
		long a[] = { 1, 8, 8 };
		long b[] = { 2, 3, 4, 5 };
		mergeTwoSortedArraysWithoutExtraSpace(a, b);
		for (long i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (long i : b) {
			System.out.print(i + " ");
		}
	}
}
