package com.leetcode_practice.problems.medium;

public class BestTimeToBuyAndSellStock_122 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                maxProfit += diff;
            }
        }
        return maxProfit;
    }

    public int maxProfit_tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[i][buy] = Math.max((-prices[i] + dp[i + 1][0]), dp[i + 1][1]);
                } else {
                    dp[i][buy] = Math.max((prices[i] + dp[i + 1][1]), dp[i + 1][0]);
                }
            }
        }
        return dp[0][1];
    }

    public int maxProfit_tab_so(int[] prices) {
        int n = prices.length;
        int[] after = new int[2];
        int[] curr = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max((-prices[i] + after[0]), after[1]);
                } else {
                    curr[buy] = Math.max((prices[i] + after[1]), after[0]);
                }
            }
            after = curr;
        }

        return after[1];
    }
}
