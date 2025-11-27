package com.leetcode_practice.problems.hard;

import java.util.Arrays;

public class PathsInMatrixWhoseSumIsDivisibleByK_2435 {

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][k];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return f(0, 0, grid[0][0] % k, grid, k, dp);
    }

    private int f(int row, int col, int rem, int[][] grid, int k, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        int MODULO = (int) (1e9) + 7;
        if (row == n - 1 && col == m - 1) {
            return (rem % k == 0) ? 1 : 0;
        }
        if (dp[row][col][rem] != -1)
            return dp[row][col][rem];
        int right = 0;
        int down = 0;

        if (col < m - 1) {
            int currRem = (rem + (grid[row][col + 1] % k)) % k;
            right = (f(row, col + 1, currRem, grid, k, dp)) % MODULO;
        }
        if (row < n - 1) {
            int currRem = (rem + (grid[row + 1][col] % k)) % k;
            down = (f(row + 1, col, currRem, grid, k, dp)) % MODULO;
        }
        return dp[row][col][rem] = (right + down) % MODULO;
    }

    public int numberOfPaths_Tab(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int MODULO = (int) (1e9) + 7;
        int[][][] dp = new int[n][m][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int rem = 0; rem < k; rem++) {
                    int left = 0;
                    int up = 0;
                    int nextRem = (rem + grid[i][j]) % k;
                    if (j > 0) {
                        left = dp[i][j - 1][rem] % MODULO;
                    }
                    if (i > 0) {
                        up = dp[i - 1][j][rem] % MODULO;
                    }
                    dp[i][j][nextRem] = (dp[i][j][nextRem] + left + up) % MODULO;
                }
            }
        }
        return dp[n - 1][m - 1][0];
    }
}
