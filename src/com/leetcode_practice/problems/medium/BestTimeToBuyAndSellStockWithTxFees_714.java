package com.leetcode_practice.problems.medium;

public class BestTimeToBuyAndSellStockWithTxFees_714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] after = new int[2];
        int[] curr = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max((-prices[i] + after[0]),
                            after[1]);
                } else {
                    curr[buy] = Math.max((prices[i] - fee + after[1]),
                            after[0]);
                }

            }
            after = curr;
        }
        return after[1];
    }
}
