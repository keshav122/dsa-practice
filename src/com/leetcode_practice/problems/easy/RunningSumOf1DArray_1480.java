package com.leetcode_practice.problems.easy;

public class RunningSumOf1DArray_1480 {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        // Not modifying the input array as it is not a best practice , although it
        // improves
        // SC in submission
        int[] ans = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + nums[i];
        }
        return ans;
    }
}
