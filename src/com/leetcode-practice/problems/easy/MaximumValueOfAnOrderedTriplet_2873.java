package com.leetcode-practice.problems.easy;

public class MaximumValueOfAnOrderedTriplet_2873 {
    public long maximumTripletValue_BF(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long diff = (nums[i] - nums[j]) * 1L;
                    long product = diff * nums[k];
                    ans = Math.max(ans, product);
                }
            }
        }
        return ans;
    }

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] maxFromRight = new int[n];
        maxFromRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(nums[i], maxFromRight[i + 1]);
        }

        long ans = 0;
        int maxValSoFar = nums[0];
        for (int i = 1; i < n - 1; i++) {
            long maxDiff = maxValSoFar - nums[i];
            ans = Math.max(ans, maxDiff * maxFromRight[i + 1]);
            maxValSoFar = Math.max(maxValSoFar, nums[i]);
        }
        return ans;
    }
}
