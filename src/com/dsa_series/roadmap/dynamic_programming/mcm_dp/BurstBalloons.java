package com.dsa_series.roadmap.dynamic_programming.mcm_dp;

import java.util.Arrays;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = 1;
        for (int i = 1; i <= n; i++) {
            a[i] = nums[i - 1];
        }
        a[n + 1] = 1;
        return f(1, n, a);
    }

    private int f(int i, int j, int[] a) {
        if (i > j) {
            return 0;
        }
        int maxCoins = 0;
        for (int ind = i; ind <= j; ind++) {
            int coins = a[i - 1] * a[ind] * a[j + 1] + f(i, ind - 1, a) + f(ind + 1, j, a);
            maxCoins = Math.max(coins, maxCoins);
        }
        return maxCoins;
    }

    public int maxCoins_M(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = 1;
        System.arraycopy(nums, 0, a, 1, n);
        a[n + 1] = 1;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(1, n, a, dp);
    }

    private int f(int i, int j, int[] a, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int maxCoins = 0;
        for (int ind = i; ind <= j; ind++) {
            int coins = a[i - 1] * a[ind] * a[j + 1] + f(i, ind - 1, a, dp) + f(ind + 1, j, a, dp);
            maxCoins = Math.max(coins, maxCoins);
        }
        return dp[i][j] = maxCoins;
    }

    public int maxCoins_Tab(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = 1;
        System.arraycopy(nums, 0, a, 1, n);
        a[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int maxCoins = 0;
                for (int ind = i; ind <= j; ind++) {
                    int coins = a[i - 1] * a[ind] * a[j + 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    maxCoins = Math.max(coins, maxCoins);
                }
                dp[i][j] = maxCoins;
            }
        }
        return dp[1][n];
    }
}
