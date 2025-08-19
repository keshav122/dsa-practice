package com.dsa_series.roadmap.dynamic_programming.dp_on_stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    public int stockBuySellIt(int[] arr, int n) {
        int curPrice = arr[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > curPrice) {
                profit += arr[i] - curPrice;
            }
            curPrice = arr[i];
        }
        return profit;
    }

    public int stockBuySellRec(int[] arr, int n) {
        return f(0, 1, arr, n);
    }

    public int f(int index, int buy, int[] arr, int n) {
        if (index == n) {
            return 0;
        }
        int profit = 0;
        if (buy == 1) {
            // max of whether you bought or not
            profit = Math.max((-arr[index] + f(index + 1, 0, arr, n)), 0 + f(index + 1, 1, arr, n));
        } else {
            // max of whether you sold or not
            profit = Math.max((arr[index] + f(index + 1, 1, arr, n)), 0 + f(index + 1, 0, arr, n));
        }
        return profit;
    }

    public int stockBuySellRecMem(int[] arr, int n) {
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 1, arr, n, dp);
    }

    private int f(int index, int buy, int[] arr, int n, int[][] dp) {
        if (index == n) {
            return 0;
        }
        if (dp[index][buy] != -1)
            return dp[index][buy];
        int profit = 0;
        if (buy == 1) {
            // max of whether you bought or not
            profit = Math.max((-arr[index] + f(index + 1, 0, arr, n, dp)), 0 + f(index + 1, 1, arr, n, dp));
        } else {
            // max of whether you sold or not
            profit = Math.max((arr[index] + f(index + 1, 1, arr, n, dp)), 0 + f(index + 1, 0, arr, n, dp));
        }
        return dp[index][buy] = profit;
    }

    public int stockBuySellRecTab(int[] arr, int n) {
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    // max of whether you bought or not
                    dp[i][buy] = Math.max((-arr[i] + dp[i + 1][0]), 0 + dp[i + 1][1]);
                } else {
                    // max of whether you sold or not
                    dp[i][buy] = Math.max((arr[i] + dp[i + 1][1]), 0 + dp[i + 1][0]);
                }
            }

        }
        return dp[0][1];
    }

    public int stockBuySellRecTab_SO(int[] arr, int n) {
        int[] front = new int[2];
        front[0] = front[1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int[] temp = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    // max of whether you bought or not
                    profit = Math.max((-arr[i] + front[0]), 0 + front[1]);
                } else {
                    // max of whether you sold or not
                    profit = Math.max((arr[i] + front[1]), 0 + front[0]);
                }
                temp[buy] = profit;
            }
            front = temp;
        }
        return front[1];
    }
}
