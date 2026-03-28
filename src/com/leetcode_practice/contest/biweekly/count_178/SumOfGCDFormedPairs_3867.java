package com.leetcode_practice.contest.biweekly.count_178;

import java.util.Arrays;

public class SumOfGCDFormedPairs_3867 {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            prefixGcd[i] = gcd(nums[i], max);
        }
        Arrays.sort(prefixGcd);
        long sum = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            sum += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
