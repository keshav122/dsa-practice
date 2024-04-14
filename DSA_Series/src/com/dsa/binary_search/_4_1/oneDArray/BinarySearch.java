package com.dsa.binary_search._4_1.oneDArray;

public class BinarySearch {

	public static int search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int search_Recursive(int[] nums, int target) {
		return search(nums, 0, nums.length - 1, target);
	}

	private static int search(int[] nums, int low, int high, int target) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return search(nums, low, mid - 1, target);
		} else {
			return search(nums, mid + 1, high, target);
		}

	}

}
