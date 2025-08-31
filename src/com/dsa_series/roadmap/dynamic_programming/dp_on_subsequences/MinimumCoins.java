package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

public class MinimumCoins {
    public int minimumCoins(int[] coins, int amount) {
        int n = coins.length;
        return f(n - 1, coins, amount);
    }

    private int f(int index, int[] coins, int amount) {
        if (index == 0) {
            if (amount % coins[index] == 0) {
                return amount / coins[index];
            } else {
                return (int) (1e9);
            }
        }
        int notPick = f(index - 1, coins, amount);
        int pick = (int) (1e9);
        if (coins[index] <= amount) {
            pick = 1 + f(index, coins, amount - coins[index]);
        }
        return Math.min(pick, notPick);
    }

    public int minimumCoins_M(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res = f(n - 1, coins, amount, dp);
        if (res >= (int) (1e9))
            return -1;
        return res;
    }

    private int f(int index, int[] coins, int amount, int[][] dp) {

        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return (int) (1e9);
            }
        }
        if (dp[index][amount] != -1)
            return dp[index][amount];
        int notPick = f(index - 1, coins, amount, dp);
        int pick = (int) (1e9);
        if (coins[index] <= amount) {
            pick = 1 + f(index, coins, amount - coins[index], dp);
        }
        return dp[index][amount] = Math.min(pick, notPick);
    }

    public int minimumCoins_tab(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int t = 1; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            } else {
                dp[0][t] = (int) (1e9);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int tg = 1; tg <= amount; tg++) {
                int notPick = dp[i - 1][tg];
                int pick = (int) (1e9);
                if (coins[i] <= tg) {
                    pick = 1 + dp[i][tg - coins[i]];
                }
                dp[i][tg] = Math.min(pick, notPick);
            }
        }
        if (dp[n - 1][amount] >= (int) (1e9))
            return -1;
        return dp[n - 1][amount];
    }

    public int minimumCoins_tab_so(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        for (int t = 1; t <= amount; t++) {
            if (t % coins[0] == 0) {
                prev[t] = t / coins[0];
            } else {
                prev[t] = (int) (1e9);
            }
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            for (int tg = 1; tg <= amount; tg++) {
                int notPick = prev[tg];
                int pick = (int) (1e9);
                if (coins[i] <= tg) {
                    pick = 1 + curr[tg - coins[i]];
                }
                curr[tg] = Math.min(pick, notPick);
            }
            prev = curr;
        }
        if (prev[amount] >= (int) (1e9))
            return -1;
        return prev[amount];
    }
}
