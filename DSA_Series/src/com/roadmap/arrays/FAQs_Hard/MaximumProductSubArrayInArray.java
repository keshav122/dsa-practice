package com.roadmap.arrays.FAQs_Hard;

public class MaximumProductSubArrayInArray {
    public int maxProduct_BF(int[] nums) {
        int max_product = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                max_product = Math.max(max_product, product);
                if (product == 0) {
                    product = 1;
                }
            }
        }
        return max_product;
    }

    public int maxProduct_Optimal(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        int max_product = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            max_product = Math.max(max_product, Math.max(prefix, suffix));
        }
        return max_product;
    }
}

# Author: keshav122
