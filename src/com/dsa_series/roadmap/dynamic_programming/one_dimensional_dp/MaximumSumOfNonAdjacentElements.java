package com.dsa_series.roadmap.dynamic_programming.one_dimensional_dp;

import java.util.Arrays;

public class MaximumSumOfNonAdjacentElements {
    public int nonAdjacent_BF(int[] nums) {
        return nonAdjacent(nums, nums.length - 1);
    }

    private int nonAdjacent(int[] nums, int index) {
        if (index == 0)
            return nums[0];
        if (index < 0)
            return 0;

        int notPick = nonAdjacent(nums, index - 1);
        int pick = nonAdjacent(nums, index - 2) + nums[index];
        return Math.max(notPick, pick);
    }

    public int nonAdjacent_Memoization(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return nonAdjacent(nums, nums.length - 1, dp);
    }

    private int nonAdjacent(int[] nums, int index, int[] dp) {
        if (index == 0)
            return nums[0];
        if (index < 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];
        int notPick = nonAdjacent(nums, index - 1, dp);
        int pick = nonAdjacent(nums, index - 2, dp) + nums[index];
        return dp[index] = Math.max(pick, notPick);
    }

    public int nonAdjacent_Tabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int notPick = dp[i - 1];
            int pick = nums[i];
            if (i > 1) {
                pick += dp[i - 2];
            }
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];
    }

    public int nonAdjacent_Tabulation_SO(int[] nums) {
        int prev2 = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int notPick = prev;
            int pick = nums[i];
            if (i > 1) {
                pick += prev2;
            }
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

}
