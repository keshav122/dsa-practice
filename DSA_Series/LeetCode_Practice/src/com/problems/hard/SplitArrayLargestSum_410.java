package com.problems.hard;

public class SplitArrayLargestSum_410 {

	public int splitArray(int[] nums, int k) {
		int n = nums.length;
		if (k > n)
			return -1;
		int minSASum = 0;
		int maxSASum = 0;
		for (Integer i : nums) {
			minSASum = Math.max(minSASum, i);
			maxSASum += i;

		}
		while (minSASum <= maxSASum) {
			int subArrSum = (minSASum + maxSASum) / 2;
			if (subArraySum(nums, subArrSum, n) <= k) {
				maxSASum = subArrSum - 1;
			} else {
				minSASum = subArrSum + 1;
			}
		}
		return minSASum;
	}

	private static int subArraySum(int[] nums, int allowedSum, int n) {
		int subArrayCount = 1;
		long sum = 0;
		for (int i = 0; i < n; i++) {
			if (sum + nums[i] <= allowedSum) {
				sum += nums[i];
			} else {
				subArrayCount++;
				sum = nums[i];
			}
		}
		return subArrayCount;
	}

}
