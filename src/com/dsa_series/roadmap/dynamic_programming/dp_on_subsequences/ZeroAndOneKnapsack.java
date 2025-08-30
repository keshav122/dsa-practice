package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

public class ZeroAndOneKnapsack {
    public int knapsack01(int[] wt, int[] val, int n, int W) {
        return f(n - 1, 0, wt, val, W);
    }

    private int f(int index, int currVal, int[] wt, int[] val, int allowedWt) {
        if (wt[index] > allowedWt)
            return 0;
        if (index == 0) {
            return wt[index] <= allowedWt ? currVal + val[index] : 0;
        }
        int notPick = f(index - 1, currVal, wt, val, allowedWt);
        int pick = 0;
        if (wt[index] <= allowedWt) {
            pick = f(index - 1, currVal + val[index], wt, val, allowedWt - wt[index]);
        }
        return Math.max(pick, notPick);
    }
}
