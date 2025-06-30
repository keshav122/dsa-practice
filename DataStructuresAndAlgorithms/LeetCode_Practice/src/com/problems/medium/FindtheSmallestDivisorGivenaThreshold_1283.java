package com.problems.medium;

public class FindtheSmallestDivisorGivenaThreshold_1283{

	public int smallestDivisor(int[] nums, int threshold) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		for (int i = 1; i <= Math.pow(10, 6); i++) {
			int sum = 0;
			for (int a : nums) {
              sum += Math.ceilDiv(a, i);
			}
			if (sum <= threshold) {
				return i;
			}
		}
		return -1;
	}
	
	public int smallestDivisor1(int[] nums, int threshold) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		int low = 1;
		int high = max;
		int smallDiv = Integer.MAX_VALUE;
		while (low <= high) {
			int mid = (low + high)/2;
			int sum = 0;
			for (int a : nums) {
				 sum += Math.ceilDiv(a, mid);
			}
			if (sum <= threshold) {
				smallDiv = Math.min(smallDiv, mid);
				high = mid-1;
			}else {
				low = mid + 1;
			}
		}
		return smallDiv;
	}
}
