package com.problems.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays_4 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		List<Integer> li = new ArrayList<>();
		for (int i : nums1) {
			li.add(i);
		}

		for (int i : nums2) {
			li.add(i);
		}
		Collections.sort(li);
		int n = nums1.length + nums2.length;

		if (n % 2 != 0) {
			return li.get(n / 2);
		} else {
			int val = (li.get(n / 2) + li.get((n / 2) - 1));
			return val / (double) (2.0);
		}
	}

	public double findMedianSortedArrays_Better(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		int n = n1 + n2;
		int ele2 = n / 2;
		int ele1 = ele2 - 1;
		int count = 0;

		int i = 0, j = 0;
		int ind1el = -1, ind2el = -1;
		while (i < n1 && j < n2) {
			if (nums1[i] < nums2[j]) {
				if (count == ele1)
					ind1el = nums1[i];
				if (count == ele2)
					ind2el = nums1[i];
				i++;
				count++;
			} else {
				if (count == ele1)
					ind1el = nums2[j];
				if (count == ele2)
					ind2el = nums2[j];
				j++;
				count++;
			}
		}

		while (i < n1) {
			if (count == ele1)
				ind1el = nums1[i];
			if (count == ele2)
				ind2el = nums1[i];
			i++;
			count++;
		}

		while (j < n2) {
			if (count == ele1)
				ind1el = nums2[j];
			if (count == ele2)
				ind2el = nums2[j];
			j++;
			count++;
		}

		if (n % 2 == 0) {
			return (ind1el + ind2el) / (double) (2.0);
		} else {
			return ind2el;
		}
	}

	public static void main(String[] args) {

	}
}
