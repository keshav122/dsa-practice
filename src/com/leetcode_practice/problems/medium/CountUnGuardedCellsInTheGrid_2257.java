package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class CountUnGuardedCellsInTheGrid_2257 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] ans = new char[m][n];
        for (char[] a : ans) {
            Arrays.fill(a, 'X');
        }
        for (int[] guard : guards) {
            ans[guard[0]][guard[1]] = 'G';
        }
        for (int[] wall : walls) {
            ans[wall[0]][wall[1]] = 'W';
        }
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];
            // changing row into guarded cells
            // move rightward
            for (int i = col + 1; i < n; i++) {
                if (ans[row][i] == 'W') {
                    break;
                } else {
                    ans[row][i] = 'G';
                }
            }

            // move leftward
            for (int i = col - 1; i >= 0; i--) {
                if (ans[row][i] == 'W') {
                    break;
                } else {
                    ans[row][i] = 'G';
                }
            }

            // changing col into guarded cells
            // move bottomwards
            for (int i = row + 1; i < m; i++) {
                if (ans[i][col] == 'W') {
                    break;
                } else {
                    ans[i][col] = 'G';
                }
            }
            // move topwards
            for (int i = row - 1; i >= 0; i--) {
                if (ans[i][col] == 'W') {
                    break;
                } else {
                    ans[i][col] = 'G';
                }
            }
        }
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 'X')
                    count++;
            }
        }
        return count;
    }

    public int countUnguarded_optimal(int m, int n, int[][] guards, int[][] walls) {
        char[][] ans = new char[m][n];
        for (char[] a : ans) {
            Arrays.fill(a, 'X');
        }

        for (int[] guard : guards) {
            ans[guard[0]][guard[1]] = 'G';
        }
        for (int[] wall : walls) {
            ans[wall[0]][wall[1]] = 'W';
        }
        for (int row = 0; row < m; row++) {
            // L to R
            boolean guarded = false;
            for (int col = 0; col < n; col++) {
                if (ans[row][col] == 'W') {
                    guarded = false;
                } else if (ans[row][col] == 'G') {
                    guarded = true;
                } else if (guarded && ans[row][col] == 'X') {
                    ans[row][col] = 'V';
                }
            }

            // R to L
            guarded = false;
            for (int col = n - 1; col >= 0; col--) {
                if (ans[row][col] == 'W') {
                    guarded = false;
                } else if (ans[row][col] == 'G') {
                    guarded = true;
                } else if (guarded && ans[row][col] == 'X') {
                    ans[row][col] = 'V';
                }
            }
        }

        // cols
        for (int col = 0; col < n; col++) {
            // to to bottom
            boolean guarded = false;
            for (int row = 0; row < m; row++) {
                if (ans[row][col] == 'W') {
                    guarded = false;
                } else if (ans[row][col] == 'G') {
                    guarded = true;
                } else if (guarded && ans[row][col] == 'X') {
                    ans[row][col] = 'V';
                }
            }

            // bottom to top
            guarded = false;
            for (int row = m - 1; row >= 0; row--) {
                if (ans[row][col] == 'W') {
                    guarded = false;
                } else if (ans[row][col] == 'G') {
                    guarded = true;
                } else if (guarded && ans[row][col] == 'X') {
                    ans[row][col] = 'V';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 'X')
                    count++;
            }
        }
        return count;
    }
}
