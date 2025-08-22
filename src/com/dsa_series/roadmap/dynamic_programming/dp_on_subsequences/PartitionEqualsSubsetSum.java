package com.dsa_series.roadmap.dynamic_programming.dp_on_subsequences;

import java.util.Arrays;

public class PartitionEqualsSubsetSum {

    // 0 to n
    public boolean equalPartition_Rec1(int n, int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 2 != 0)
            return false;
        // Same question as subset equals to target
        int target = sum / 2;
        return f(arr, 0, 0, target);
    }

    private boolean f(int[] arr, int index, int leftSubsetSum, int target) {
        if (leftSubsetSum == target)
            return true;
        if (index == arr.length)
            return false;
        if (leftSubsetSum > target)
            return false;// Pruning
        return f(arr, index + 1, leftSubsetSum + arr[index], target) ||
                f(arr, index + 1, leftSubsetSum, target);

    }

    // n-1 to 0
    public boolean equalPartition_Rec2(int n, int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 2 != 0)
            return false;
        // Same question as subset equals to target
        int target = sum / 2;
        return f(arr, n - 1, target);
    }

    private boolean f(int[] arr, int index, int target) {
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

    public boolean equalPartitionMEM(int n, int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(arr, n - 1, target, dp);
    }

    private boolean f(int[] arr, int index, int target, int[][] dp) {
        if (target == 0)
            return true;
        if (index == 0)
            return (arr[index] == target);

        if (dp[index][target] != -1) {
            return dp[index][target] == 0 ? false : true;
        }
        boolean notTake = f(arr, index - 1, target, dp);
        boolean take = false;
        if (target >= arr[index]) {
            take = f(arr, index - 1, target - arr[index], dp);
        }
        dp[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }

    public boolean equalPartitionTab(int n, int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
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

    public boolean equalPartitionTab_SO(int n, int[] arr) {
        int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        boolean[] prev = new boolean[target + 1];
        for (int i = 0; i < n; i++) {
            prev[0] = true;
        }
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            boolean[] curr = new boolean[target + 1];
            for (int j = 0; j <= target; j++) {
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
