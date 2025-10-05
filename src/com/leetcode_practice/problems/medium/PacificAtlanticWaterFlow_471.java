package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow_471 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            bfs(n - 1, i, atlantic, heights);
            bfs(0, i, pacific, heights);
        }
        for (int j = 0; j < n; j++) {
            bfs(j, m - 1, atlantic, heights);
            bfs(j, 0, pacific, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(int r, int c, boolean[][] vis, int[][] heights) {
        int[] dRow = { -1, 0, 1, 0 };
        int[] dCol = { 0, -1, 0, 1 };
        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        vis[r][c] = true;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for (int i = 0; i < 4; i++) {
                int nR = row + dRow[i];
                int nC = col + dCol[i];
                if (isValid(nR, nC, n, m) && heights[nR][nC] >= heights[row][col] && !vis[nR][nC]) {
                    vis[nR][nC] = true;
                    q.add(new int[] { nR, nC });
                }
            }
        }
    }

    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n)
            return false;
        if (j < 0 || j >= m)
            return false;

        return true;
    }
}
