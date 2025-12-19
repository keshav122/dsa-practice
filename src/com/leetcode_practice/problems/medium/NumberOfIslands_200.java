package com.leetcode_practice.problems.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands_200 {
    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, -1, 0, 1 };

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    islands++;

                }
            }
        }
        return islands;
    }

    private void bfs(int row, int col, char[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        q.add(new int[] { row, col });
        grid[row][col] = '0';
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for (int i = 0; i < 4; i++) {
                int nR = r + delRow[i];
                int nC = c + delCol[i];
                if (nR >= 0 && nR < m && nC >= 0 && nC < n && grid[nR][nC] == '1') {
                    grid[nR][nC] = '0';
                    q.add(new int[] { nR, nC });
                }
            }
        }
    }
}
