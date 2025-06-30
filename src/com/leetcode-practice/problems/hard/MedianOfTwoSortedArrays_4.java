package com.leetcode-practice.problems.hard;

/*Author: keshav122 */
package com.problems.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays_4 {

	public double findMedianSortedArrays_BF(int[] nums1, int[] nums2) {
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

	// Binary Serach - Most Optimal
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		if (n1 > n2)
			return findMedianSortedArrays(nums2, nums1);
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
				r1 = nums1[mid1];
			if (mid2 < n2)
				r2 = nums2[mid2];
			if (mid1 - 1 >= 0)
				l1 = nums1[mid1 - 1];
			if (mid2 - 1 >= 0)
				l2 = nums2[mid2 - 1];

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

	public double findMedianSortedArrays_Revision(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		// Number of elements on the left side
		if(n1 > n2) return findMedianSortedArrays_Revision(nums2, nums1);
		int left = (n1 + n2 + 1) / 2;
		int n = n1 + n2;
		int low = 0;
		int high = n1;
		while (low <= high) {
			int mid1 = (low + high) >> 1; // Number of elements we want from nums1 for left half
			int mid2 = left - mid1;// Number of elements we want from nums2 for left half
			int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
			int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
			if (mid1 < n1)
				r1 = nums1[mid1];
			if (mid2 < n2)
				r2 = nums2[mid2];
			if (mid1 >= 1)
				l1 = nums1[mid1 - 1];
			if (mid2 >= 1)
				l2 = nums2[mid2 - 1];
			if (l1 <= r2 && l2 <= r1) {
				if (n % 2 == 0)
					return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
				else
					return Math.max(l1, l2);
			} else if (l1 > r2)
				high = mid1 - 1;
			else
				low = mid1 + 1;

		}
		return 0;
	}

	public static void main(String[] args) {

	}
}
