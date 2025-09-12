package com.dsa_series.roadmap.dynamic_programming.mcm_dp;

import java.util.Arrays;
import java.util.List;

public class MinimumCostToCutTheStick {
    public int minCost(int n, List<Integer> cuts) {
        int c = cuts.size();
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts.get(i);
        }
        newCuts[c + 1] = n;
        Arrays.sort(newCuts);
        return f(1, c, newCuts);
    }

    private int f(int i, int j, int[] cuts) {
        if (i > j) {
            return 0;
        }

        int mini = (int) (1e9);
        for (int ind = i; ind <= j; ind++) {
            int ans = cuts[j + 1] - cuts[i - 1] + f(i, ind - 1, cuts) + f(ind + 1, j, cuts);
            mini = Math.min(ans, mini);
        }
        return mini;
    }

    public int minCost_M(int n, List<Integer> cuts) {
        int c = cuts.size();
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts.get(i);
        }
        newCuts[c + 1] = n;
        Arrays.sort(newCuts);
        int[][] dp = new int[c + 1][c + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(1, c, newCuts, dp);
    }

    private int f(int i, int j, int[] cuts, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1)
            return dp[i][j];
        int mini = (int) (1e9);
        for (int ind = i; ind <= j; ind++) {
            int ans = cuts[j + 1] - cuts[i - 1] + f(i, ind - 1, cuts, dp) + f(ind + 1, j, cuts, dp);
            mini = Math.min(ans, mini);
        }
        return dp[i][j] = mini;
    }

    public int minCost_Tab(int n, List<Integer> cuts) {
        int c = cuts.size();
        int[] newCuts = new int[c + 2];
        newCuts[0] = 0;
        for (int i = 0; i < c; i++) {
            newCuts[i + 1] = cuts.get(i);
        }
        newCuts[c + 1] = n;
        Arrays.sort(newCuts);
        int[][] dp = new int[c + 1][c + 1];
        for (int i = c; i >= 1; i--) {
            for (int j = i + 1; j <= c; j++) {
                int mini = (int) (1e9);
                for (int ind = i; ind <= j; ind++) {
                    int ans = newCuts[j + 1] - newCuts[i - 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(ans, mini);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }

}
