package com.leetcode_practice.problems.medium;

public class MaximumMatrixSum_1975 {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int smallest = (int) (1e9);
        int negativeCount = 0;
        int zeros = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    negativeCount++;
                    int abs = -1 * matrix[i][j];
                    smallest = Math.min(abs, smallest);
                    sum += abs;
                } else if (matrix[i][j] > 0) {
                    sum += matrix[i][j];
                    smallest = Math.min(matrix[i][j], smallest);
                } else {
                    zeros++;
                }
            }

        }

        if (negativeCount % 2 == 0 || (negativeCount % 2 == 1 && zeros > 0)) {
            return sum;
        }
        return sum - 2 * smallest;

    }
}
