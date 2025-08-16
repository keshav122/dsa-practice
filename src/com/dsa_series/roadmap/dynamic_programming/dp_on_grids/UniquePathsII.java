package com.dsa_series.roadmap.dynamic_programming.dp_on_grids;

import java.util.Arrays;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        return uniquePathsWithObstacles(matrix, n - 1, m - 1);
    }

    private int uniquePathsWithObstacles(int[][] matrix, int i, int j) {
        if (i == 0 && j == 0 && matrix[i][j] == 0) {
            return 1;
        }

        if (i < 0 || j < 0 || matrix[i][j] == 1) {
            return 0;
        }

        int left = uniquePathsWithObstacles(matrix, i, j - 1);
        int up = uniquePathsWithObstacles(matrix, i - 1, j);
        return up + left;
    }

    public int uniquePathsWithObstaclesMem(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniquePathsWithObstacles(matrix, n - 1, m - 1, dp);
    }

    private int uniquePathsWithObstacles(int[][] matrix, int i, int j, int[][] dp) {
        if (i == 0 && j == 0 && matrix[i][j] == 0) {
            return 1;
        }

        if (i < 0 || j < 0 || matrix[i][j] == 1) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        return dp[i][j] = uniquePathsWithObstacles(matrix, i, j - 1, dp)
                + uniquePathsWithObstacles(matrix, i - 1, j, dp);
    }

    public int uniquePathsWithObstaclesTabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = (i > 0 && matrix[i - 1][j] == 0) ? dp[i - 1][j] : 0;
                int left = (j > 0 && matrix[i][j - 1] == 0) ? dp[i][j - 1] : 0;
                dp[i][j] = up + left;
            }
        }
        return dp[n - 1][m - 1];
    }

    public int uniquePathsWithObstaclesTabulation_SO(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    temp[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = (i > 0 && matrix[i - 1][j] == 0) ? prev[j] : 0;
                int left = (j > 0 && matrix[i][j - 1] == 0) ? temp[j - 1] : 0;
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[m - 1];
    }

}
