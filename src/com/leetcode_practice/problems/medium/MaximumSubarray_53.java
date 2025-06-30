package com.leetcode_practice.problems.medium;

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
	
	//Kadane 's Algorithm
	public int maxSubArray(int[] nums) {
		int max_so_far = nums[0];
		int max_ending_here = nums[0];
		for(int i = 1; i< nums.length ; i++) {
			max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		return max_so_far ;
	}
	
	public int maxSubArray_1(int[] nums) {
		 int maxSum = nums[0];
	       int sum =0;
			for(int i = 0; i< nums.length ; i++) {
				sum += nums[i];
				maxSum = Math.max(sum, maxSum);
				if(sum < 0) sum = 0;
			}
			return maxSum ;
	}
}
