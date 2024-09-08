package com.roadmap.arrays.FAQs_Medium;

public class KadaneAlgorithm {

    public int maxSubArray_BF(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    public int maxSubArray_Better(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    // Using Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int sum_so_far = 0;
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum_so_far += nums[i];
            max_sum = Math.max(max_sum, sum_so_far);
            if (sum_so_far < 0) {
                sum_so_far = 0;
            }
        }
        return max_sum;
    }
}
