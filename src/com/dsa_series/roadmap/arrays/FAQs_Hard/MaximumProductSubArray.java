package com.dsa_series.roadmap.arrays.FAQs_Hard;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int product_so_far = 1;
        int max_product = Integer.MIN_VALUE;
        for (int num : nums) {
            product_so_far *= num;
            max_product = Math.max(max_product, product_so_far);
        }
        return max_product;
    }

}
