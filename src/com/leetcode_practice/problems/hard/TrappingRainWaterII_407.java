package com.leetcode_practice.problems.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII_407 {

    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        if (n < 3 || m < 3) {
            return 0;
        }

        // Push all boundary elements
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    pq.add(new int[] { heightMap[i][j], i, j });
                    vis[i][j] = true;
                }
            }
        }

        // Apply BFS
        int level = 0;
        int trappedWater = 0;
        int[] delRow = { 0, 1, 0, -1 };
        int[] delCol = { 1, 0, -1, 0 };
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int height = node[0];
            int r = node[1];
            int c = node[2];
            level = Math.max(level, height);

            for (int i = 0; i < 4; i++) {
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];
                if (isValid(nRow, nCol, n, m) && !vis[nRow][nCol]) {
                    vis[nRow][nCol] = true;
                    pq.add(new int[] { heightMap[nRow][nCol], nRow, nCol });
                    if (heightMap[nRow][nCol] < level) {
                        trappedWater += level - heightMap[nRow][nCol];
                    }
                }
            }
        }
        return trappedWater;
    }

    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n)
            return false;
        if (j < 0 || j >= m)
            return false;

        return true;
    }
}
