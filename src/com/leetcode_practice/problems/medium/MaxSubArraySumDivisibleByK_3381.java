package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class MaxSubArraySumDivisibleByK_3381 {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if ((j - i + 1) % k == 0) {
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }

    public long maxSubarraySum_better(int[] nums, int k) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + k; j <= n; j += k) {
                maxSum = Math.max(maxSum, prefix[j] - prefix[i]);
            }
        }
        return maxSum;
    }

    public long maxSubarraySum_Optimal(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }
        long[] bestPrefix = new long[k];
        Arrays.fill(bestPrefix, Long.MAX_VALUE);
        bestPrefix[0] = 0;
        long maxSum = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int mod = i % k;
            if (bestPrefix[mod] != Long.MAX_VALUE) {
                maxSum = Math.max(maxSum, prefix[i] - bestPrefix[mod]);
            }
            bestPrefix[mod] = Math.min(bestPrefix[mod], prefix[i]);
        }
        return maxSum;
    }
}
