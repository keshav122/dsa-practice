package com.leetcode_practice.problems.hard;

public class BestTimeToBuyAndSellStockIV_188 {
    public int maxProfit(int k, int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        dp[i][1][cap] = Math.max(-arr[i] + dp[i + 1][0][cap],
                                0 + dp[i + 1][1][cap]);
                    } else {
                        dp[i][0][cap] = Math.max(arr[i] + dp[i + 1][1][cap - 1],
                                0 + dp[i + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}
