package com.dsa.binary_search._4_1.oneDArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SingleElementinaSortedArray {

	// We can also perform a frequency Map based solution
	public static int singleNonDuplicate_BF(ArrayList<Integer> arr) {

		Set<Integer> set = new HashSet<>();
		set.addAll(arr);
		int actualSum = 0;
		for (Integer i : arr) {
			actualSum += i;
		}

		int desiredSum = 0;
		for (Integer i : set) {
			desiredSum += i;
		}
		return (2 * desiredSum) - actualSum;
	}

	public static int singleNonDuplicate_Optimal(ArrayList<Integer> arr) {
		int n = arr.size();
		if (n ==  1)
			return arr.get(0);
		if (!arr.get(0).equals(arr.get(1)))
			return arr.get(0);
		if (!arr.get(n - 1).equals( arr.get(n - 2)))
			return arr.get(n - 1);

		int low = 1;
		int high = n - 2;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (!arr.get(mid).equals(arr.get(mid - 1)) && !arr.get(mid).equals(arr.get(mid + 1))) {
				return arr.get(mid);
			}

			// we have to eliminate the half in which the element is not present
			if ((mid % 2 == 1 && arr.get(mid - 1).equals(arr.get(mid)))
					|| (mid % 2 ==  0 && arr.get(mid).equals( arr.get(mid + 1)))) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}
		return -1;
	}

}
