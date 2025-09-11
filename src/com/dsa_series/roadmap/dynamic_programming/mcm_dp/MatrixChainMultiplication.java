package com.dsa_series.roadmap.dynamic_programming.mcm_dp;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public int matrixMultiplication(int[] nums) {
        return f(1, nums.length - 1, nums);
    }

    private int f(int i, int j, int[] nums) {
        if (i == j)
            return 0;
        int mini = (int) (1e9);
        for (int k = i; k < j; k++) {
            int steps = nums[i - 1] * nums[k] * nums[j] + f(i, k, nums) + f(k + 1, j, nums);
            mini = Math.min(steps, mini);
        }
        return mini;
    }

    public int matrixMultiplication_M(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(1, n - 1, nums, dp);
    }

    private int f(int i, int j, int[] nums, int[][] dp) {
        if (i == j)
            return 0;
        int mini = (int) (1e9);
        if (dp[i][j] != -1)
            return dp[i][j];
        for (int k = i; k < j; k++) {
            int steps = nums[i - 1] * nums[k] * nums[j] + f(i, k, nums, dp) + f(k + 1, j, nums, dp);
            mini = Math.min(steps, mini);
        }
        return dp[i][j] = mini;
    }
}
