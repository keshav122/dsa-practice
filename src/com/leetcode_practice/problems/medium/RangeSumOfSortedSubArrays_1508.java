package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class RangeSumOfSortedSubArrays_1508 {

	public int rangeSum(int[] nums, int n, int left, int right) {
		int MODULO = 1000000007;
		int[] ans = new int[(n * (n + 1)) / 2];
		int k = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += nums[j];
				ans[k] = sum;
			}
		}
		Arrays.sort(ans);
		int total = 0;
		for (int i = left - 1; i < right; i++) {
			total = (total + ans[i]) % MODULO;
		}
		return total;
	}
}