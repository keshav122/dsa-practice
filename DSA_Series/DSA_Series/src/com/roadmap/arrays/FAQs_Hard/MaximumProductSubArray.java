package com.roadmap.arrays.FAQs_Hard;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int product_so_far = 1;
        int max_product = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            product_so_far *= nums[i];
            max_product = Math.max(max_product, product_so_far);
        }
        return max_product;
    }

}
