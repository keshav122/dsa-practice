package com.dsa_series.roadmap.dynamic_programming.dp_on_stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFees {
    public int stockBuySell(int[] arr, int n, int fee) {
        return stockBuySell(arr, 0, 1, fee);
    }

    private int stockBuySell(int[] arr, int index, int buy, int fee) {
        if (index == arr.length)
            return 0;

        if (buy == 1) {
            return Math.max((-arr[index] + stockBuySell(arr, index + 1, 0, fee)),
                    stockBuySell(arr, index + 1, 1, fee));
        }
        return Math.max((arr[index] - fee + stockBuySell(arr, index + 1, 1, fee)),
                stockBuySell(arr, index + 1, 0, fee));
    }

    public int stockBuySell_mem(int[] arr, int n, int fee) {
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return stockBuySell(arr, 0, 1, fee, dp);
    }

    private int stockBuySell(int[] arr, int index, int buy, int fee, int[][] dp) {
        if (index == arr.length)
            return 0;

        if (dp[index][buy] != -1)
            return dp[index][buy];
        if (buy == 1) {
            return dp[index][buy] = Math.max((-arr[index] + stockBuySell(arr, index + 1, 0, fee, dp)),
                    stockBuySell(arr, index + 1, 1, fee, dp));
        }
        return dp[index][buy] = Math.max((arr[index] - fee + stockBuySell(arr, index + 1, 1, fee, dp)),
                stockBuySell(arr, index + 1, 0, fee, dp));
    }

    public int stockBuySell_Tabulation(int[] arr, int n, int fee) {
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[i][buy] = Math.max((-arr[i] + dp[i + 1][0]),
                            dp[i + 1][1]);
                } else {
                    dp[i][buy] = Math.max((arr[i] - fee + dp[i + 1][1]),
                            dp[i + 1][0]);
                }

            }
        }
        return dp[0][1];
    }

    public int stockBuySell_Tabulation_SO(int[] arr, int n, int fee) {
        int[] after = new int[2];
        int[] curr = new int[2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max((-arr[i] + after[0]),
                            after[1]);
                } else {
                    curr[buy] = Math.max((arr[i] - fee + after[1]),
                            after[0]);
                }

            }
            after = curr;
        }
        return after[1];
    }
}
