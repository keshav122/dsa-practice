package com.leetcode_practice.problems.easy;

public class CountNegativeNumbersInASortedMatrix_1351 {

    // O(m * n)
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    count += (n - j);
                    break;
                }
            }
        }
        return count;
    }

    // O(m + n)
    public int countNegatives_optimal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                count += (m - row);
                col--;
            } else {
                row++;
            }
        }
        return count;
    }
}
