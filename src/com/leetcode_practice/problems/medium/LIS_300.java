package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class LIS_300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, -1, nums, n, dp);
    }

    private int f(int index, int prevInd, int[] nums, int n, int[][] dp) {
        if (index == n - 1) {
            if (prevInd == -1 || nums[prevInd] < nums[index])
                return 1;
            return 0;
        }
        if (dp[index][prevInd + 1] != -1)
            return dp[index][prevInd + 1];
        int notTake = f(index + 1, prevInd, nums, n, dp);
        int take = 0;
        if (prevInd == -1 || nums[index] > nums[prevInd]) {
            take = 1 + f(index + 1, index, nums, n, dp);
        }
        return dp[index][prevInd + 1] = Math.max(take, notTake);
    }
}
