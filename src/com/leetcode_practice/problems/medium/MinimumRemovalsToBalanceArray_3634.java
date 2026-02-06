package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class MinimumRemovalsToBalanceArray_3634 {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, maxWindow = 1;
        for (int r = 0; r < n; r++) {
            while ((long) nums[r] > (long) nums[l] * k) {
                l++;
            }
            maxWindow = Math.max(maxWindow, r - l + 1);
        }
        return n - maxWindow;
    }
}
