package com.leetcode_practice.problems.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SwimInRisingWater_778 {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        return bfs(0, 0, vis, grid);
    }

    private boolean isValid(int i, int j, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n)
            return false;
        return true;
    }

    private int bfs(int row, int col, boolean[][] vis, int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] dRow = { -1, 0, 1, 0 };
        int[] dCol = { 0, -1, 0, 1 };
        pq.add(new int[] { grid[0][0], row, col });
        int minVal = grid[row][col];
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int elevationSoFar = node[0];
            int r = node[1];
            int c = node[2];
            if (r == n - 1 && c == n - 1) {
                return elevationSoFar;
            }
            vis[r][c] = true;

            for (int i = 0; i < 4; i++) {
                int nR = r + dRow[i];
                int nC = c + dCol[i];
                if (isValid(nR, nC, n) && !vis[nR][nC]) {
                    pq.add(new int[] { Math.max(elevationSoFar, grid[nR][nC]), nR, nC });
                    vis[nR][nC] = true;
                }
            }
        }
        return minVal;
    }

}
