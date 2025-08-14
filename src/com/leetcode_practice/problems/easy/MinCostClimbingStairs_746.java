package com.leetcode_practice.problems.easy;

import java.util.Arrays;

public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs_BF(int[] cost) {
        return minCostClimbingStairs(cost, cost.length);
    }

    public int minCostClimbingStairs(int[] cost, int index) {
        if (index == 0 || index == 1)
            return 0;
        int left = minCostClimbingStairs(cost, index - 1) + cost[index - 1];
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = minCostClimbingStairs(cost, index - 2) + cost[index - 2];
        }
        return Math.min(left, right);
    }

    public int minCostClimbingStairs_Memoization(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minCostClimbingStairs(cost, cost.length, dp);
    }

    public int minCostClimbingStairs(int[] cost, int index, int[] dp) {
        if (index == 0 || index == 1)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int left = minCostClimbingStairs(cost, index - 1, dp) + cost[index - 1];
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = minCostClimbingStairs(cost, index - 2, dp) + cost[index - 2];
        }

        return dp[index] = Math.min(left, right);
    }

    public int minCostClimbingStairs_Tabulation(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int left = dp[i - 1] + cost[i - 1];
            int right = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(left, right);
        }
        return dp[n];
    }

    public int minCostClimbingStairs_Tabulation_SO(int[] cost) {
        int prev2 = 0;
        int prev = 0;
        for (int i = 2; i <= cost.length; i++) {
            int curr = Math.min(prev + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
