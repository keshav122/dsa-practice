package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

public class SubsetSumEqualsToTarget {
    public boolean isSubsetSum(int[] arr, int target) {
        int n = arr.length;
        return f(arr, n - 1, target);
    }

    public boolean f(int[] arr, int index, int target) {
        if (target == 0)
            return true;
        if (index == 0)
            return (arr[index] == target);
        boolean notTake = f(arr, index - 1, target);
        boolean take = false;
        if (target >= arr[index]) {
            take = f(arr, index - 1, target - arr[index]);
        }
        return take || notTake;
    }

    public boolean isSubsetSum_mem(int[] arr, int target) {
        // We cannot take a boolean dp array in the memoization
        // as we use the -1 value to highlight the unvisited cells
        int n = arr.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(arr, n - 1, target, dp);
    }

    private boolean f(int[] arr, int index, int target, int[][] dp) {
        if (target == 0)
            return true;
        if (index == 0)
            return (target == arr[index]);
        if (dp[index][target] != -1)
            return dp[index][target] == 0 ? false : true;
        boolean notTake = f(arr, index - 1, target, dp);
        boolean take = false;
        if (target >= arr[index]) {
            take = f(arr, index - 1, target - arr[index], dp);
        }

        dp[index][target] = notTake || take ? 1 : 0;
        return notTake || take;
    }

    public boolean isSubsetSum_tabulation(int[] arr, int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (j >= arr[i]) {
                    take = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }

    public boolean isSubsetSum_tabulation_So(int[] arr, int target) {
        int n = arr.length;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (j >= arr[i]) {
                    take = prev[j - arr[i]];
                }
                curr[j] = take || notTake;
            }
            prev = curr;
        }
        return prev[target];
    }
}
