package com.dsa_series.roadmap.dynamic_programming.dp_on_stocks;

public class BestTimeToBuyAndSellStock {
    public int stockBuySell_BF(int[] arr, int n) {
        int maxi = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                maxi = Math.max(maxi, arr[j] - arr[i]);
            }
        }
        return maxi;
    }

    // If we are selling on ith day , we want to buy on the minimum price
    // from 0 to (i-1)th day
    public int stockBuySell(int[] arr, int n) {
        int min = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            int cost = arr[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, arr[i]);
        }
        return maxProfit;
    }

}
