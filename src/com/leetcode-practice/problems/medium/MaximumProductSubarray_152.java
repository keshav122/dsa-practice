package com.leetcode-practice.problems.medium;

public class MaximumProductSubarray_152 {
	public int maxProduct_bF(int[] nums) {
		int maxProduct = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int product = 1;
			for (int j = i; j < nums.length; j++) {
				product *= nums[j];
				maxProduct = Math.max(maxProduct, product);
			}
		}
		return maxProduct;
	}
	
	public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
		int prefix = 1;
		int suffix = 1;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (prefix == 0)
				prefix = 1;
			if (suffix == 0)
				suffix = 1;
			prefix = prefix * nums[i];
			suffix = suffix * nums[n - i - 1];
			max = Math.max(max, Math.max(prefix, suffix));
		}
		return max;
    }
}
