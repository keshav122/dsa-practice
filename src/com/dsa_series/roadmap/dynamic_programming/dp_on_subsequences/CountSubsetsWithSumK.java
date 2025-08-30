package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

public class CountSubsetsWithSumK {
    static int MODULO = 1000000007;

    public int perfectSum_R(int[] arr, int K) {
        return f(arr, arr.length - 1, K);
    }

    private int f(int[] arr, int index, int k) {
        if (k == 0) {
            return 1;
        }
        if (index == 0) {
            return (arr[index] == k) ? 1 : 0;
        }
        int notTake = f(arr, index - 1, k);
        int take = 0;
        if (arr[index] <= k) {
            take = f(arr, index - 1, k - arr[index]);
        }
        return take + notTake;
    }

    public int perfectSum_M(int[] arr, int K) {
        int n = arr.length;
        int[][] dp = new int[n][K + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(arr, arr.length - 1, K, dp);
    }

    private int f(int[] arr, int index, int k, int[][] dp) {
        if (k == 0) {
            return 1;
        }
        if (index == 0) {
            return (arr[index] == k) ? 1 : 0;
        }
        if (dp[index][k] != -1)
            return dp[index][k];
        int notTake = f(arr, index - 1, k, dp);
        int take = 0;
        if (arr[index] <= k) {
            take = f(arr, index - 1, k - arr[index], dp);
        }
        return dp[index][k] = (take + notTake) % MODULO;
    }

    public int perfectSum_Tab(int[] arr, int K) {
        int MODULO = 1000000007;
        int n = arr.length;
        int[][] dp = new int[n][K + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= K) {
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= K; target++) {
                int notTake = dp[i - 1][target];
                int take = 0;
                if (arr[i] <= target) {
                    take = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = (take + notTake) % MODULO;
            }
        }
        return dp[n - 1][K];
    }

    public int perfectSum_Tab_So(int[] arr, int K) {
        int MODULO = 1000000007;
        int n = arr.length;
        int[] prev = new int[K + 1];
        prev[0] = 1;
        if (arr[0] <= K) {
            prev[arr[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[K + 1];
            curr[0] = 1;
            for (int target = 1; target <= K; target++) {
                int notTake = prev[target];
                int take = 0;
                if (arr[i] <= target) {
                    take = prev[target - arr[i]];
                }
                curr[target] = (take + notTake) % MODULO;
            }
            prev = curr;
        }
        return prev[K];
    }

}
