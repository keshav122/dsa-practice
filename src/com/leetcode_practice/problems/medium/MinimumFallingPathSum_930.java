package com.leetcode_practice.problems.medium;

public class MinimumFallingPathSum_930 {
    public int minFallingPathSum(int[][] matrix) {
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
