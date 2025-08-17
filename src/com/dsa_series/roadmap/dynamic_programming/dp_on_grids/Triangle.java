package com.dsa_series.roadmap.dynamic_programming.dp_on_grids;

import java.util.Arrays;

public class Triangle {
    // Starting from n-1 , m-1 is not a preferrable solution here as we have to
    // tackle
    // 4 starting points rather we can start from (0,0) and have
    // only 1 starting point
    public int minTriangleSum(int[][] triangle) {
        int n = triangle.length;
        int m = triangle[n - 1].length;
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int ans = minTriangleSum(triangle, n - 1, j, m - 1);
            mini = Math.min(ans, mini);
        }
        return mini;
    }

    public int minTriangleSum(int[][] triangle, int i, int j, int maxCols) {
        if (j < 0 || j > maxCols) {
            return (int) (1e9);
        }
        if (i == 0) {
            return triangle[i][j];
        }
        int up = triangle[i][j] + minTriangleSum(triangle, i - 1, j, maxCols - 1);
        int left = triangle[i][j] + minTriangleSum(triangle, i - 1, j - 1, maxCols - 1);
        return Math.min(up, left);
    }

    public int minTriangleSum_MEM(int[][] triangle) {
        int n = triangle.length;
        int m = triangle[n - 1].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            int ans = minTriangleSum(triangle, n - 1, j, m - 1, dp);
            mini = Math.min(ans, mini);
        }
        return mini;
    }

    public int minTriangleSum(int[][] triangle, int i, int j, int maxCols, int[][] dp) {
        if (j < 0 || j > maxCols) {
            return (int) (1e9);
        }
        if (i == 0) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = triangle[i][j] + minTriangleSum(triangle, i - 1, j, maxCols - 1);
        int left = triangle[i][j] + minTriangleSum(triangle, i - 1, j - 1, maxCols - 1);
        return dp[i][j] = Math.min(up, left);
    }

    public int minTriangleSum_Tabulation(int[][] triangle) {
        int n = triangle.length;
        int m = triangle[n - 1].length;
        int[][] dp = new int[n][m];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int up = (j >= i) ? triangle[i][j] + dp[i - 1][j] : (int) (1e9);
                int left = (j > 0) ? triangle[i][j] + dp[i - 1][j - 1] : (int) (1e9);
                dp[i][j] = Math.min(up, left);
            }
        }

        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(dp[n - 1][j], mini);
        }
        return mini;
    }

    public int minTriangleSum_Tabulation_SO(int[][] triangle) {
        int n = triangle.length;
        int m = triangle[n - 1].length;
        int[] prev = new int[m];
        prev[0] = triangle[0][0];
        for (int i = 1; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < i + 1; j++) {
                int up = (j < i) ? triangle[i][j] + prev[j] : (int) (1e9);
                int left = (j > 0) ? triangle[i][j] + prev[j - 1] : (int) (1e9);
                temp[j] = Math.min(up, left);
            }
            prev = temp;
        }

        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            mini = Math.min(prev[j], mini);
        }
        return mini;
    }

    // Recursion with starting from 0,0
    public int minTriangleSumRecursionBetter(int[][] triangle) {
        int n = triangle.length;
        return minTriangleSum(triangle, 0, 0, n);
    }

    public int minTriangleSumRecursionBetter(int[][] triangle, int i, int j, int n) {
        if (i == n - 1) {
            return triangle[i][j];
        }
        int down = triangle[i][j] + minTriangleSumRecursionBetter(triangle, i + 1, j, n);
        int rightDiagonal = triangle[i][j] + minTriangleSumRecursionBetter(triangle, i + 1, j + 1, n);
        return Math.min(down, rightDiagonal);
    }

    public int minTriangleSum_MEM_better(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minTriangleSum_MEM_better(triangle, 0, 0, n, dp);
    }

    public int minTriangleSum_MEM_better(int[][] triangle, int i, int j, int n, int[][] dp) {
        if (i == n - 1) {
            return triangle[i][j];
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = triangle[i][j] + minTriangleSum_MEM_better(triangle, i + 1, j, n, dp);
        int rightDiagonal = triangle[i][j] + minTriangleSum_MEM_better(triangle, i + 1, j + 1, n, dp);
        return dp[i][j] = Math.min(down, rightDiagonal);
    }

    // Must be of the opposite order of what is followed in recursion
    // In the better recursive solution we started from (0,0)
    // So in tabulation we will start from N-1
    public int minTriangleSum_Tabulation_btter(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i + 1][j];
                int rightDiagonal = triangle[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, rightDiagonal);
            }
        }
        return dp[0][0];
    }

    public int minTriangleSum_Tabulation_SO_better(int[][] triangle) {
        int n = triangle.length;
        int[] next = new int[n];
        for (int j = 0; j < n; j++) {
            next[j] = triangle[n - 1][j];
        }
        for (int i = n - 2; i >= 0; i--) {
            int[] temp = new int[n];
            for (int j = i; j >= 0; j--) {
                int down = triangle[i][j] + next[j];
                int rightDiagonal = triangle[i][j] + next[j + 1];
                temp[j] = Math.min(down, rightDiagonal);
            }
            next = temp;
        }
        return next[0];
    }
}
