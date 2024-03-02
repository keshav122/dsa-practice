package com.dsa.arrays_3_2_medium;

public class BestTimeToBuyAndSellStock {

	// 11/12 - REST TLE
	public static int bestTimeToBuyAndSellStock(int[] prices) {
		int maxProfit = 0;
		int n = prices.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (prices[j] < prices[i]) {
					break;
				} else {
					int diff = prices[j] - prices[i];
					maxProfit = Math.max(maxProfit, diff);
				}
			}
		}
		return maxProfit;
	}

	public static int bestTimeToBuyAndSellStock_Improved(int[] prices) {
		int max_Dif = 0;
		int min_value_so_far = prices[0];
		for (int i = 1; i < prices.length; i++) {
			max_Dif = Math.max(prices[i] - min_value_so_far, max_Dif);
			min_value_so_far = Math.min(min_value_so_far, prices[i]);
		}
		return max_Dif;  
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 4, 3, 6 };
		System.out.println(bestTimeToBuyAndSellStock_Improved(prices));
	}
}
