package com.codestudio.cn.guidedpaths.dsa.arrays.kadanealgorithm;

public class MaximumSubarraySum {

	public static long maxSubarraySum(int[] arr, int n) {
		long maxSum = 0;
		long sum = 0;
		
		for(int i = 0; i< arr.length;i++){
			sum += arr[i];
			maxSum = Long.max(sum, maxSum);
			if(sum < 0){
				sum  = 0;
			}
		}
		return maxSum;
	}
}
