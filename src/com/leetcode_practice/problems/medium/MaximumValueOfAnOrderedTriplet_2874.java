package com.leetcode_practice.problems.medium;

public class MaximumValueOfAnOrderedTriplet_2874 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] maxFromRight = new int[n];
        maxFromRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(nums[i], maxFromRight[i + 1]);
        }
        int maxFromLeft = nums[0];
        long ans = 0;
        for (int i = 1; i < n - 1; i++) {
            long diff = maxFromLeft - nums[i];
            ans = Math.max(ans, diff * maxFromRight[i + 1]);
            maxFromLeft = Math.max(maxFromLeft, nums[i]);
        }
        return ans;
    }
}
