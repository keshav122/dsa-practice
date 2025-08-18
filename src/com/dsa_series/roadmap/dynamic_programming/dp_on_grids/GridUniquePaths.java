package com.dsa_series.roadmap.dynamic_programming.dp_on_grids;

import java.util.Arrays;

public class GridUniquePaths {
    public int uniquePathsRecursive(int m, int n) {
        return uniquePaths(0, 0, m - 1, n - 1);
    }

    private int uniquePaths(int row, int col, int rows, int cols) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0)
            return 0;
        int up = uniquePaths(row - 1, col, rows, cols);
        int left = uniquePaths(row, col - 1, rows, cols);
        return up + left;
    }

    public int uniquePathsMemoized(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniquePaths(m - 1, n - 1, dp);
    }

    private int uniquePaths(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = uniquePaths(i - 1, j, dp) + uniquePaths(i, j - 1, dp);
    }

    public int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    dp[0][0] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePathsTabulationSO(int m, int n) {
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = (i > 0) ? prev[j] : 0;
                int left = (j > 0) ? temp[j - 1] : 0;
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n - 1];
    }
}
