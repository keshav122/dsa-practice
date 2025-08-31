package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

public class ZeroAndOneKnapsack {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        // f(ind, W) denoyes upto index i what maximum value we can generate
        // with a allowed bag weight of W.
        return f(n - 1, wt, val, W);
    }

    private int f(int index, int[] wt, int[] val, int allowedWt) {

        if (allowedWt == 0)
            return 0;
        if (index == 0) {
            return wt[index] <= allowedWt ? val[index] : 0;
        }

        int notPick = f(index - 1, wt, val, allowedWt);
        int pick = 0;
        if (wt[index] <= allowedWt) {
            pick = val[index] + f(index - 1, wt, val, allowedWt - wt[index]);
        }
        return Math.max(pick, notPick);
    }

    public int knapsack01_M(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, wt, val, W, dp);
    }

    private int f(int index, int[] wt, int[] val, int w, int[][] dp) {
        if (w == 0)
            return 0;
        if (index == 0) {
            return wt[index] <= w ? val[index] : 0;
        }
        if (dp[index][w] != -1)
            return dp[index][w];
        int notPick = f(index - 1, wt, val, w, dp);
        int pick = 0;
        if (wt[index] <= w) {
            pick = val[index] + f(index - 1, wt, val, w - wt[index], dp);
        }
        return dp[index][w] = Math.max(pick, notPick);
    }

    public int knapsack01_Tab(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int w = 0; w <= W; w++) {
            if (w >= wt[0]) {
                dp[0][w] = val[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int w = 1; w <= W; w++) {
                int notPick = dp[i - 1][w];
                int pick = 0;
                if (wt[i] <= w) {
                    pick = val[i] + dp[i - 1][w - wt[i]];
                }
                dp[i][w] = Math.max(pick, notPick);
            }
        }
        return dp[n - 1][W];
    }

    public int knapsack01_Tab_So(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];
        for (int w = 0; w <= W; w++) {
            if (w >= wt[0]) {
                prev[w] = val[0];
            }
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[W + 1];
            curr[0] = 0;
            for (int w = 1; w <= W; w++) {
                int notPick = prev[w];
                int pick = 0;
                if (wt[i] <= w) {
                    pick = val[i] + prev[w - wt[i]];
                }
                curr[w] = Math.max(pick, notPick);
            }
            prev = curr;
        }
        return prev[W];
    }
}
