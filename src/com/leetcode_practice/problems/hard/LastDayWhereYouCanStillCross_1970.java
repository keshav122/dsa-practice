package com.leetcode_practice.problems.hard;

import java.util.ArrayDeque;
import java.util.Queue;

public class LastDayWhereYouCanStillCross_1970 {
    public int latestDayToCross_BF(int row, int col, int[][] cells) {
        int low = 0, high = cells.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int[][] mat = new int[row][col];
            updateGrid(mat, mid, cells);
            if (!isTraversalPossible(mat, row, col)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low - 1;
    }

    private void updateGrid(int[][] mat, int day, int[][] cells) {
        for (int i = 0; i < day; i++) {
            mat[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
    }

    private boolean isTraversalPossible(int[][] grid, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        // Start from all land cells in top row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 0) {
                q.add(new int[] { 0, j });
                visited[0][j] = true;
            }
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            if (r == n - 1)
                return true; // reached bottom row

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                        grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return false;

    }
}
