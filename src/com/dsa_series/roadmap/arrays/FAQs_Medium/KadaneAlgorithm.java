package com.dsa_series.roadmap.arrays.FAQs_Medium;

/*Author: keshav122 */

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

    // Follow up for Kadane algorithm - To print the max sum subarray range
    public int[] maxSubArrayWithRanges(int[] nums) {
        int sum_so_far = 0;
        int max_sum = Integer.MIN_VALUE;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sum_so_far == 0) {
                ansStart = i;
            }
            sum_so_far += nums[i];
            if (sum_so_far > max_sum) {
                max_sum = sum_so_far;
                ansEnd = i;
            }
            if (sum_so_far < 0) {
                sum_so_far = 0;
            }
        }
        return new int[] { ansStart, ansEnd };
    }
}
