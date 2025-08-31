package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

public class CoinChangeII {
    static int MODULO = (int) (1e9) + 7;

    public int count(int[] coins, int n, int T) {
        int res = f(n - 1, coins, T) % MODULO;
        if (res >= (int) (1e9)) {
            return 0;
        }
        return res;
    }

    public int f(int index, int[] coins, int T) {
        if (index == 0) {
            if (T % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int notTaken = f(index - 1, coins, T);
        int taken = 0;
        if (coins[index] <= T) {
            taken = f(index, coins, T - coins[index]);
        }
        return notTaken + taken;
    }

    public int count_M(int[] coins, int n, int T) {
        int[][] dp = new int[n][T + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res = f(n - 1, coins, T, dp) % MODULO;
        if (res >= (int) (1e9)) {
            return 0;
        }
        return res;
    }

    private int f(int index, int[] coins, int T, int[][] dp) {
        if (index == 0) {
            if (T % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[index][T] != -1)
            return dp[index][T];
        int notTaken = f(index - 1, coins, T);
        int taken = 0;
        if (coins[index] <= T) {
            taken = f(index, coins, T - coins[index]);
        }
        return dp[index][T] = (notTaken + taken) % MODULO;
    }

    public int count_tab(int[] coins, int n, int T) {
        int MODULO = (int) (1e9) + 7;
        int[][] dp = new int[n][T + 1];

        for (int t = 0; t <= T; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int tg = 0; tg <= T; tg++) {
                int notTaken = dp[i - 1][tg];
                int taken = 0;
                if (coins[i] <= tg) {
                    taken = dp[i][tg - coins[i]];
                }
                dp[i][tg] = (notTaken + taken) % MODULO;
            }
        }
        return dp[n - 1][T];
    }

    public int count_tab_so(int[] coins, int n, int T) {
        int MODULO = (int) (1e9) + 7;
        int[] prev = new int[T + 1];

        for (int t = 0; t <= T; t++) {
            if (t % coins[0] == 0) {
                prev[t] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[T + 1];
            for (int tg = 0; tg <= T; tg++) {
                int notTaken = prev[tg];
                int taken = 0;
                if (coins[i] <= tg) {
                    taken = curr[tg - coins[i]];
                }
                curr[tg] = (notTaken + taken) % MODULO;
            }
            prev = curr;
        }
        return prev[T];
    }
}
