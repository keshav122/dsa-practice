package com.problems.medium;

public class MaximumSubarray_53 {

	//TL exceeded in Leetcode
	public int maxSubArray_BruteForce(int[] nums) {
	       int maxSum = nums[0];
	       int n = nums.length;
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = i; j < n; j++) {
					sum += nums[j];
					maxSum = Math.max(maxSum, sum);
				}
			}
			return maxSum;
	    }
	
	public int maxSubArray(int[] nums) {
		int max_so_far = nums[0];
		int max_ending_here = nums[0];
		for(int i = 1; i< nums.length ; i++) {
			max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		return max_so_far ;
	}
}
