package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

public class UnboundedKnapSack {
    public int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        return f(n - 1, wt, val, W);
    }

    private int f(int index, int[] wt, int[] val, int w) {
        if (w == 0 || index < 0)
            return 0;
        if (index == 0) {
            if (wt[0] <= w) {
                return ((w / wt[0]) * val[0]);
            }
        }

        int notTaken = f(index - 1, wt, val, w);
        int taken = 0;
        if (wt[index] <= w) {
            taken = val[index] + f(index, wt, val, w - wt[index]);
        }
        return Math.max(notTaken, taken);
    }

    public int unboundedKnapsack_M(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, wt, val, W, dp);
    }

    private int f(int index, int[] wt, int[] val, int w, int[][] dp) {
        if (w == 0 || index < 0)
            return 0;
        if (index == 0) {
            if (wt[0] <= w) {
                return ((w / wt[0]) * val[0]);
            }
        }

        if (dp[index][w] != -1)
            return dp[index][w];
        int notTaken = f(index - 1, wt, val, w, dp);
        int taken = 0;
        if (wt[index] <= w) {
            taken = val[index] + f(index, wt, val, w - wt[index], dp);
        }
        return dp[index][w] = Math.max(notTaken, taken);
    }

    public int unboundedKnapsack_tab(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W + 1];
        for (int w = 0; w <= W; w++) {
            if (wt[0] <= w) {
                dp[0][w] = ((w / wt[0]) * val[0]);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                int notTaken = dp[i - 1][w];
                int taken = 0;
                if (wt[i] <= w) {
                    taken = val[i] + dp[i][w - wt[i]];
                }
                dp[i][w] = Math.max(notTaken, taken);
            }
        }

        return dp[n - 1][W];
    }

    public int unboundedKnapsack_tab_SO(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W + 1];
        for (int w = 0; w <= W; w++) {
            if (wt[0] <= w) {
                prev[w] = ((w / wt[0]) * val[0]);
            }
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[W + 1];
            for (int w = 0; w <= W; w++) {
                int notTaken = prev[w];
                int taken = 0;
                if (wt[i] <= w) {
                    taken = val[i] + curr[w - wt[i]];
                }
                curr[w] = Math.max(notTaken, taken);
            }
            prev = curr;
        }

        return prev[W];
    }
}
