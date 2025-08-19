package com.leetcode_practice.problems.hard;

public class BestTimeToBuyAndSellStock_123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;
                    if (buy == 1) {
                        // the cap will reduce only when both buy and sell are performed
                        int take = -prices[i] + after[0][cap];
                        int notTake = 0 + after[1][cap];
                        profit = Math.max(take, notTake);
                    } else {
                        int sell = prices[i] + after[1][cap - 1];
                        int notSell = 0 + after[0][cap];
                        profit = Math.max(sell, notSell);
                    }
                    curr[buy][cap] = profit;
                }
            }
            after = curr;
        }
        return after[1][2];
    }
}
