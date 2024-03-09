package com.dsa.arrays_3_2_medium;

public class SubarraywithMaxSum {

	public int maxSubArray_BruteForce(int[] nums) {
		int n = nums.length;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += nums[k];
				}
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}

	public int maxSubArray_BruteForceOptimised(int[] nums) {
		int n = nums.length;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}

	//Kadane's Algo approach
	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			maxSum = Math.max(sum, maxSum);
			if (sum < 0)
				sum = 0;
		}
		return maxSum;
	}
}
