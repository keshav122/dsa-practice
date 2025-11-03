package com.leetcode_practice.problems.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {
    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, 1, 0, -1 };

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    // row, col, initialTime
                    q.add(new int[] { i, j, 0 });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // BFS
        int maxTime = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            int t = node[2];
            maxTime = Math.max(t, maxTime);
            for (int i = 0; i < 4; i++) {
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];
                if (isValid(nRow, nCol, n, m) && grid[nRow][nCol] == 1) {
                    grid[nRow][nCol] = 2;
                    q.add(new int[] { nRow, nCol, t + 1 });
                    count++;// turned fresh into rotten
                }
            }
        }
        return (count == fresh) ? maxTime : -1;
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
