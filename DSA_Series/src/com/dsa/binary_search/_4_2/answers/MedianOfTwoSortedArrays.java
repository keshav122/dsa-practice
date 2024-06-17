package com.dsa.binary_search._4_2.answers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays {

	public static double median(int[] a, int[] b) {
		List<Integer> li = new ArrayList<>();
		for (int i : a) {
			li.add(i);
		}

		for (int i : b) {
			li.add(i);
		}
		Collections.sort(li);
		int n = a.length + b.length;

		if (n % 2 != 0) {
			return li.get(n / 2);
		} else {
			int val = (li.get(n / 2) + li.get((n / 2) - 1));
			return val / (double) (2.0);
		}
	}

	public static double median_Better(int[] a, int[] b) {
		int n1 = a.length;
		int n2 = b.length;
		int n = n1 + n2;

		int ele2 = n / 2;
		int ele1 = ele2 - 1;
		int count = 0;

		int i = 0, j = 0;
		int ind1el = -1, ind2el = -1;
		while (i < n1 && j < n2) {
			if (a[i] < b[j]) {
				if (count == ele1)
					ind1el = a[i];
				if (count == ele2)
					ind2el = a[i];
				i++;
				count++;
			} else {
				if (count == ele1)
					ind1el = b[j];
				if (count == ele2)
					ind2el = b[j];
				j++;
				count++;
			}
		}

		while (i < n1) {
			if (count == ele1)
				ind1el = a[i];
			if (count == ele2)
				ind2el = a[i];
			i++;
			count++;
		}

		while (j < n2) {
			if (count == ele1)
				ind1el = b[j];
			if (count == ele2)
				ind2el = b[j];
			j++;
			count++;
		}

		if (n % 2 == 0) {
			return (ind1el + ind2el) / (double) (2.0);
		} else {
			return ele2;
		}

	}

	public static double median_BinarySearch_MostOptimal(int[] a, int[] b) {
		int n1 = a.length;
		int n2 = b.length;
		if (n1 > n2)
			return median(b, a);
		int low = 0;
		int high = n1;
		// number of elements we require on left
		int left = (n1 + n2 + 1) / 2;
		int n = n1 + n2;
		while (low <= high) {
			int mid1 = (low + high) >> 1;// doing low + high / 2
			int mid2 = left - mid1;
			int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
			if (mid1 < n1)
				r1 = a[mid1];
			if (mid2 < n2)
				r2 = b[mid2];
			if (mid1 - 1 >= 0)
				l1 = a[mid1 - 1];
			if (mid2 - 1 >= 0)
				l2 = b[mid2 - 1];

			if (l1 <= r2 && l2 <= r1) {
				if (n % 2 == 1)
					return Math.max(l1, l2);
				return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
			} else if (l1 > r2)
				high = mid1 - 1;
			else
				low = mid1 + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] a = { 2 };
		int[] b = { 1, 3 };
		System.out.println(median(a, b));
	}
}
