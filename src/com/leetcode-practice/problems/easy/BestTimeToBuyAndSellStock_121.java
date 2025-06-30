package com.leetcode-practice.problems.easy;

public class BestTimeToBuyAndSellStock_121 {

	// giving TLE
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		int n = prices.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int diff = prices[j] - prices[i];
				maxProfit = Math.max(maxProfit, diff);
			}
		}
		return maxProfit;
	}
}
