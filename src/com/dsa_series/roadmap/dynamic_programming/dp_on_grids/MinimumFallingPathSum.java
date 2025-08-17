package com.dsa_series.roadmap.dynamic_programming.dp_on_grids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumFallingPathSum {

    public int minFallingPathSumMyRecSol(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> pathSums = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            minFallingPathSum(matrix, n - 1, i, 0, pathSums, m);
        }
        Collections.sort(pathSums);
        return pathSums.get(0);
    }

    private void minFallingPathSum(
            int[][] matrix, int i, int j, int currSum, List<Integer> pathSums, int m) {

        if (i < 0 || j < 0 || j >= m) {
            return;
        }
        if (i == 0) {
            currSum += matrix[i][j];
            pathSums.add(currSum);
            return;
        }

        // left upper diagonal
        minFallingPathSum(matrix, i - 1, j - 1, currSum + matrix[i][j], pathSums, m);
        // up
        minFallingPathSum(matrix, i - 1, j, currSum + matrix[i][j], pathSums, m);
        // right upper diagonal
        minFallingPathSum(matrix, i - 1, j + 1, currSum + matrix[i][j], pathSums, m);
    }

    public int minFallingPathSumRec(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int ans = minFallingPathSum(matrix, n - 1, j, m);
            minimum = Math.min(ans, minimum);
        }
        return minimum;
    }

    private int minFallingPathSum(int[][] matrix, int i, int j, int m) {
        if (j < 0 || j >= m) {
            return (int) 1e9;
        }
        if (i == 0) {
            return matrix[i][j];
        }

        // left upper diagonal
        int ld = matrix[i][j] + minFallingPathSum(matrix, i - 1, j - 1, m);
        // up
        int up = matrix[i][j] + minFallingPathSum(matrix, i - 1, j, m);
        // right upper diagonal
        int rd = matrix[i][j] + minFallingPathSum(matrix, i - 1, j + 1, m);

        return Math.min(up, Math.min(ld, rd));
    }

    public int minFallingPathSumMem(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int ans = minFallingPathSum(matrix, n - 1, j, m, dp);
            minimum = Math.min(ans, minimum);
        }
        return minimum;
    }

    private int minFallingPathSum(int[][] matrix, int i, int j, int m, int[][] dp) {
        if (j < 0 || j >= m) {
            return (int) 1e9;
        }
        if (i == 0) {
            return matrix[i][j];
        }

        if (dp[i][j] != -1)
            return dp[i][j];
        // left upper diagonal
        int ld = matrix[i][j] + minFallingPathSum(matrix, i - 1, j - 1, m, dp);
        // up
        int up = matrix[i][j] + minFallingPathSum(matrix, i - 1, j, m, dp);
        // right upper diagonal
        int rd = matrix[i][j] + minFallingPathSum(matrix, i - 1, j + 1, m, dp);
        return dp[i][j] = Math.min(up, Math.min(ld, rd));
    }

    public int minFallingPathSumTabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                // left upper diagonal
                int ld = (j > 0) ? matrix[i][j] + dp[i - 1][j - 1] : (int) (1e9);
                // up
                int up = matrix[i][j] + dp[i - 1][j];
                // right upper diagonal
                int rd = (j < m - 1) ? matrix[i][j] + dp[i - 1][j + 1] : (int) (1e9);
                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minimum = Math.min(dp[n - 1][j], minimum);
        }
        return minimum;
    }

    public int minFallingPathSumTabulationSO(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] prev = new int[m];
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                // left upper diagonal
                int ld = (j > 0) ? matrix[i][j] + prev[j - 1] : (int) (1e9);
                // up
                int up = matrix[i][j] + prev[j];
                // right upper diagonal
                int rd = (j < m - 1) ? matrix[i][j] + prev[j + 1] : (int) (1e9);
                temp[j] = Math.min(up, Math.min(ld, rd));
            }
            prev = temp;
        }
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minimum = Math.min(prev[j], minimum);
        }
        return minimum;
    }
}
