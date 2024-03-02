package com.dsa.arrays_3_2_medium;

public class MaximumSubarraySum {

	//3 loops
	public static long maxSubarraySum(int[] arr, int n) {
		long maxSum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				long sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				maxSum = Math.max(maxSum, sum);
			}
		}
		
		return maxSum;
	}
	
	public static long maxSubarraySum_Way1(int[] arr, int n) {
		long maxSum = 0;
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}
	
	public static long maxSubarraySum_Way2(int[] arr, int n) {
		long max_so_far = arr[0];
		long max_ending_here = arr[0];
		for(int i = 1; i< n ; i++) {
			max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		return max_so_far;
	}
	
	public static void main(String[] args) {
		int arr[] = {10,20,-30,40,-50,60};
	}
}
