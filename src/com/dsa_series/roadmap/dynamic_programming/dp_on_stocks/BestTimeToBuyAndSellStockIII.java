/*Author: keshav122 */
package com.dsa_series.roadmap.dynamic_programming.dp_on_stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {
    public int stockBuySell(int[] arr, int n) {
        return stockBuySell(arr, 0, 1, 2);
    }

    private int stockBuySell(int[] arr, int index, int buy, int cap) {
        if (cap == 0)
            return 0;
        if (index == arr.length)
            return 0;

        int profit = 0;
        // If we can buy
        if (buy == 1) {
            // the cap will reduce only when both buy and sell are performed
            int take = -arr[index] + stockBuySell(arr, index + 1, 0, cap);
            int notTake = 0 + stockBuySell(arr, index + 1, 1, cap);
            profit = Math.max(take, notTake);
        } else {
            int sell = arr[index] + stockBuySell(arr, index + 1, 1, cap - 1);
            int notSell = 0 + stockBuySell(arr, index + 1, 0, cap);
            profit = Math.max(sell, notSell);
        }
        return profit;
    }

    public int stockBuySellTX(int[] arr, int n) {
        return stockBuySell_Alt(arr, 0, 0, 2);
    }

    // This is a bit of alternative approach where we go by the transaction number
    private int stockBuySell_Alt(int[] arr, int index, int transactionNumber, int cap) {
        if (transactionNumber == 4 || index == arr.length)
            return 0;

        int profit = 0;

        // Transaction Number divisible 2 means it is a buy transaction
        if (transactionNumber % 2 == 0) {
            // the cap will reduce only when both buy and sell are performed
            int take = -arr[index] + stockBuySell_Alt(arr, index + 1, transactionNumber + 1, cap);
            int notTake = 0 + stockBuySell_Alt(arr, index + 1, transactionNumber, cap);
            profit = Math.max(take, notTake);
        } else {
            int sell = arr[index] + stockBuySell_Alt(arr, index + 1, transactionNumber + 1, cap - 1);
            int notSell = 0 + stockBuySell_Alt(arr, index + 1, transactionNumber, cap);
            profit = Math.max(sell, notSell);
        }
        return profit;
    }

    public int stockBuySell_mem(int[] arr, int n) {
        int[][][] dp = new int[n][2][3];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return stockBuySell(arr, 0, 1, 2, dp);
    }

    private int stockBuySell(int[] arr, int index, int buy, int cap, int[][][] dp) {
        if (cap == 0)
            return 0;
        if (index == arr.length)
            return 0;

        if (dp[index][buy][cap] != -1)
            return dp[index][buy][cap];
        int profit = 0;
        if (buy == 1) {
            // the cap will reduce only when both buy and sell are performed
            int take = -arr[index] + stockBuySell(arr, index + 1, 0, cap, dp);
            int notTake = 0 + stockBuySell(arr, index + 1, 1, cap, dp);
            profit = Math.max(take, notTake);
        } else {
            int sell = arr[index] + stockBuySell(arr, index + 1, 1, cap - 1, dp);
            int notSell = 0 + stockBuySell(arr, index + 1, 0, cap, dp);
            profit = Math.max(sell, notSell);
        }
        return dp[index][buy][cap] = profit;
    }

    public int stockBuySell_tab(int[] arr, int n) {

        int[][][] dp = new int[n + 1][2][3];

        // We can avoid writing the base cases as the values are already 0
        // // If cap is 0 , ind and buy can be anything
        // for (int i = 0; i <= n - 1; i++) {
        // for (int buy = 0; buy <= 1; buy++) {
        // dp[i][buy][0] = 0;
        // }
        // }
        // // If index is n , cap and buy can be anything
        // for (int buy = 0; buy <= 1; buy++) {
        // for (int cap = 0; cap <= 2; cap++) {
        // dp[n][buy][0] = 0;
        // }
        // }

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;
                    if (buy == 1) {
                        // the cap will reduce only when both buy and sell are performed
                        int take = -arr[i] + dp[i + 1][0][cap];
                        int notTake = 0 + dp[i + 1][1][cap];
                        profit = Math.max(take, notTake);
                    } else {
                        int sell = arr[i] + dp[i + 1][1][cap - 1];
                        int notSell = 0 + dp[i + 1][0][cap];
                        profit = Math.max(sell, notSell);
                    }
                    dp[i][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][2];
    }

    public int stockBuySell_tab_so(int[] arr, int n) {
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
            }
            after = curr;
        }
        return after[1][2];
    }
}
