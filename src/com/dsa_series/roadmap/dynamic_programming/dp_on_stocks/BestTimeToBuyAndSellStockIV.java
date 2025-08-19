package com.dsa_series.roadmap.dynamic_programming.dp_on_stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public int stockBuySell(int[] arr, int n, int k) {
        return stockBuySell(arr, 0, 1, k);
    }

    private int stockBuySell(int[] arr, int index, int buy, int cap) {
        if (index == arr.length || cap == 0)
            return 0;
        if (buy == 1) {
            return Math.max(-arr[index] + stockBuySell(arr, index + 1, 0, cap),
                    0 + stockBuySell(arr, index + 1, 1, cap));
        }
        return Math.max(arr[index] + stockBuySell(arr, index + 1, 1, cap - 1),
                0 + stockBuySell(arr, index + 1, 0, cap));
    }

    public int stockBuySell_MEM(int[] arr, int n, int k) {
        int[][][] dp = new int[n][2][k + 1];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return stockBuySell(arr, 0, 1, k, dp);
    }

    private int stockBuySell(int[] arr, int index, int buy, int cap, int[][][] dp) {
        if (index == arr.length || cap == 0)
            return 0;

        if (dp[index][buy][cap] != -1)
            return dp[index][buy][cap];
        if (buy == 1) {
            dp[index][1][cap] = Math.max(-arr[index] + stockBuySell(arr, index + 1, 0, cap, dp),
                    0 + stockBuySell(arr, index + 1, 1, cap, dp));
        } else {
            dp[index][0][cap] = Math.max(arr[index] + stockBuySell(arr, index + 1, 1, cap - 1, dp),
                    0 + stockBuySell(arr, index + 1, 0, cap, dp));
        }
        return dp[index][buy][cap];
    }

    public int stockBuySell_Tabulation(int[] arr, int n, int k) {
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

    public int stockBuySell_Tabulation_SO(int[] arr, int n, int k) {
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;
                    if (buy == 1) {
                        // the cap will reduce only when both buy and sell are performed
                        int take = -arr[i] + after[0][cap];
                        int notTake = 0 + after[1][cap];
                        profit = Math.max(take, notTake);
                    } else {
                        int sell = arr[i] + after[1][cap - 1];
                        int notSell = 0 + after[0][cap];
                        profit = Math.max(sell, notSell);
                    }
                    curr[buy][cap] = profit;
                }
                after = curr;
            }
        }
        return after[1][2];
    }
}
