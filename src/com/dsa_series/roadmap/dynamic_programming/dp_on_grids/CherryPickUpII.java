/*Author: keshav122 */
package com.dsa_series.roadmap.dynamic_programming.dp_on_grids;

import java.util.Arrays;

public class CherryPickUpII {
    public int cherryPickup(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        return func(0, 0, m - 1, n, m, matrix);
    }

    private int func(int i, int j1, int j2, int r, int c, int[][] matrix) {
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) {
            return (int) (-(1e8));
        }

        if (i == r - 1) {
            if (j1 == j2)
                return matrix[i][j1];
            else
                return matrix[i][j1] + matrix[i][j2];
        }

        // Explore all paths of both the robots simultaneously
        int maximum = (int) -(1e8);
        // As the robots can move left diagonal , right diagonal and down
        // For every 1 movement of robot 1 there are three corresponding movements
        // of robot 2.
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2)
                    value = matrix[i][j1];
                else
                    value = matrix[i][j1] + matrix[i][j2];

                value += func(i + 1, j1 + dj1, j2 + dj2, r, c, matrix);
                maximum = Math.max(maximum, value);
            }
        }
        return maximum;
    }

    public int cherryPickup_mem(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][][] dp = new int[n][m][m];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return func(0, 0, m - 1, n, m, matrix, dp);
    }

    private int func(int i, int j1, int j2, int r, int c, int[][] matrix, int[][][] dp) {
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) {
            return (int) (-(1e8));
        }

        if (i == r - 1) {
            if (j1 == j2)
                return matrix[i][j1];
            else
                return matrix[i][j1] + matrix[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        // Explore all paths of both the robots simultaneously
        int maximum = (int) -(1e8);
        // As the robots can move left diagonal , right diagonal and down
        // For every 1 movement of robot 1 there are three corresponding movements
        // of robot 2.
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = 0;
                if (j1 == j2)
                    value = matrix[i][j1];
                else
                    value = matrix[i][j1] + matrix[i][j2];

                value += func(i + 1, j1 + dj1, j2 + dj2, r, c, matrix, dp);
                maximum = Math.max(maximum, value);
            }
        }
        return dp[i][j1][j2] = maximum;
    }

    public int cherryPickup_tab(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][][] dp = new int[n][m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = matrix[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maximum = (int) -(1e8);
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value = 0;
                            if (j1 == j2)
                                value = matrix[i][j1];
                            else
                                value = matrix[i][j1] + matrix[i][j2];
                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += dp[i + 1][j1 + dj1][j2 + dj2];
                            } else {
                                value += -1e8;
                            }
                            maximum = Math.max(maximum, value);
                        }
                    }
                    dp[i][j1][j2] = maximum;
                }
            }
        }
        return dp[0][0][m - 1];
    }

    public int cherryPickup_tab_so(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] front = new int[m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = matrix[n - 1][j1];
                else
                    front[j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int[][] temp = new int[m][m];
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maximum = (int) -(1e8);
                    for (int dj1 = -1; dj1 <= 1; dj1++) {
                        for (int dj2 = -1; dj2 <= 1; dj2++) {
                            int value = 0;
                            if (j1 == j2)
                                value = matrix[i][j1];
                            else
                                value = matrix[i][j1] + matrix[i][j2];
                            if (j1 + dj1 >= 0 && j1 + dj1 < m && j2 + dj2 >= 0 && j2 + dj2 < m) {
                                value += front[j1 + dj1][j2 + dj2];
                            } else {
                                value += -1e8;
                            }
                            maximum = Math.max(maximum, value);
                        }
                    }
                    temp[j1][j2] = maximum;
                }
            }
            front = temp;
        }
        return front[0][m - 1];
    }
}
