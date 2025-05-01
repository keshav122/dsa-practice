package com.problems.hard;

public class ReversePairs_493 {

	public int reversePairs(int[] nums) {
		int count = 0;
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] > 2 * nums[j]) {
					count++;
				}
			}
		}
		return count;
	}
}
