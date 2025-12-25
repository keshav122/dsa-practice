package com.leetcode_practice.problems.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfEnclaves_1020 {
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && grid[i][j] == 1) {
                    grid[i][j] = 0;
                    q.add(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for (int d = 0; d < 4; d++) {
                int nR = r + dirs[d][0];
                int nC = c + dirs[d][1];
                if (nR >= 0 && nR < n && nC >= 0 && nC < m && grid[nR][nC] == 1) {
                    q.add(new int[] { nR, nC });
                    grid[nR][nC] = 0;
                }
            }
        }

        int enclaves = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    enclaves++;
            }
        }
        return enclaves;
    }
}
