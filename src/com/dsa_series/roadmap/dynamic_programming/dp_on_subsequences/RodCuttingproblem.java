package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

public class RodCuttingproblem {
    public int rodCutting(int price[], int len) {
        int n = price.length;
        return f(n - 1, price, len);
    }

    public int f(int index, int[] price, int len) {
        if (len == 0 || index < 0)
            return 0;
        if (index == 0) {
            if (index + 1 <= len) {
                return len * price[0];
            }
        }

        int notTake = f(index - 1, price, len);
        int take = 0;
        if (index + 1 <= len) {
            take = price[index] + f(index, price, len - index - 1);
        }
        return Math.max(take, notTake);
    }

    public int rodCutting_M(int price[], int len) {
        int n = price.length;
        int[][] dp = new int[n][len + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, price, len, dp);
    }

    public int f(int index, int[] price, int len, int[][] dp) {
        if (len == 0 || index < 0)
            return 0;
        if (index == 0) {
            if (index + 1 <= len) {
                return len * price[0];
            }
        }
        if (dp[index][len] != -1)
            return dp[index][len];
        int notTake = f(index - 1, price, len, dp);
        int take = 0;
        if (index + 1 <= len) {
            take = price[index] + f(index, price, len - index - 1, dp);
        }
        return dp[index][len] = Math.max(take, notTake);
    }

    public int rodCutting_tab(int price[], int len) {
        int n = price.length;
        int[][] dp = new int[n][len + 1];
        for (int l = 0; l <= len; l++) {
            dp[0][l] = l * price[0];
        }
        for (int i = 1; i < n; i++) {
            for (int l = 1; l <= len; l++) {
                int notTake = dp[i - 1][l];
                int take = Integer.MIN_VALUE;
                if (i + 1 <= l) {
                    take = price[i] + dp[i][l - i - 1];
                }
                dp[i][l] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][len];
    }

    public int rodCutting_tab_SO(int price[], int len) {
        int n = price.length;
        int[] prev = new int[len + 1];
        for (int l = 0; l <= len; l++) {
            prev[l] = l * price[0];
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[len + 1];
            for (int l = 1; l <= len; l++) {
                int notTake = prev[l];
                int take = Integer.MIN_VALUE;
                if (i + 1 <= l) {
                    take = price[i] + curr[l - i - 1];
                }
                curr[l] = Math.max(take, notTake);
            }
            prev = curr;
        }

        return prev[len];
    }
}
