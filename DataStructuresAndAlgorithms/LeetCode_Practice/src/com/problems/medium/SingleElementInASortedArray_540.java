package com.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class SingleElementInASortedArray_540 {

	public int singleNonDuplicate_BF(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : nums) {
			set.add(i);
		}
		int actualSum = 0;
		for (Integer i : nums) {
			actualSum += i;
		}

		int desiredSum = 0;
		for (Integer i : set) {
			desiredSum += i;
		}
		return (2 * desiredSum) - actualSum;
	}

	public int singleNonDuplicate_Optimal(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		if (nums[0] != nums[1])
			return nums[0];
		if (nums[n - 1] != nums[n - 2])
			return nums[n - 1];

		int low = 1;
		int high = n - 2;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
				return nums[mid];
			}

			// we have to eliminate the half in which the element is not present
			if (nums[mid - 1] == nums[mid]) {
				if (mid % 2 == 0) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			if (nums[mid] == nums[mid + 1]) {
				if (mid % 2 == 0) {
					low = mid + 1;

				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}

	public int singleNonDuplicate_Optimal1(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		if (nums[0] != nums[1])
			return nums[0];
		if (nums[n - 1] != nums[n - 2])
			return nums[n - 1];

		int low = 1;
		int high = n - 2;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
				return nums[mid];
			}

			// we have to eliminate the half in which the element is not present
			if ((mid % 2 == 1 && nums[mid - 1] == nums[mid]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
