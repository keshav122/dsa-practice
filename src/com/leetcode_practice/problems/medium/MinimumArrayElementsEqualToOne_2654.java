package com.leetcode_practice.problems.medium;

public class MinimumArrayElementsEqualToOne_2654 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int oneCount = 0;
        for (int num : nums) {
            if (num == 1)
                oneCount++;
        }
        if (oneCount > 0)
            return n - oneCount;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        if (minLen == Integer.MAX_VALUE)
            return -1;
        return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
