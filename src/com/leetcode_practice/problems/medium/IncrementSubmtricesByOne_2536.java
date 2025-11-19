package com.leetcode_practice.problems.medium;

public class IncrementSubmtricesByOne_2536 {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        for (int[] query : queries) {
            int row1 = query[0], col1 = query[1], row2 = query[2], col2 = query[3];
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    ans[i][j]++;
                }
            }
        }
        return ans;
    }

    public int[][] rangeAddQueries_better(int n, int[][] queries) {
        int[][] ans = new int[n][n];
        for (int[] query : queries) {
            int row1 = query[0], col1 = query[1], row2 = query[2], col2 = query[3];
            for (int i = row1; i <= row2; i++) {
                ans[i][col1]++;
                if (col2 + 1 < n) {
                    ans[i][col2 + 1]--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] += ans[i][j - 1];
            }
        }
        return ans;
    }

    // Array Difference
    public int[][] rangeAddQueries_optimal(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];

        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            diff[r1][c1] += 1;
            if (c2 + 1 < n)
                diff[r1][c2 + 1] -= 1;
            if (r2 + 1 < n)
                diff[r2 + 1][c1] -= 1;
            if (r2 + 1 < n && c2 + 1 < n)
                diff[r2 + 1][c2 + 1] += 1;// This is important to understand
        }

        // Build 2D prefix sum
        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int top = (i > 0 ? ans[i - 1][j] : 0);
                int left = (j > 0 ? ans[i][j - 1] : 0);
                int diag = (i > 0 && j > 0 ? ans[i - 1][j - 1] : 0);

                ans[i][j] = diff[i][j] + top + left - diag;// Also understand this
            }
        }

        return ans;
    }

}
