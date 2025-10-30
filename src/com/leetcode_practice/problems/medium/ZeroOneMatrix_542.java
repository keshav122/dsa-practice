package com.leetcode_practice.problems.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix_542 {
    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, 1, 0, -1 };

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] distance = new int[n][m];

        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    q.add(new int[] { i, j, 0 });
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            int d = node[2];
            if (vis[r][c])
                continue;
            vis[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];
                if (isValid(nRow, nCol, n, m) && mat[nRow][nCol] == 1 && !vis[nRow][nCol]) {
                    distance[nRow][nCol] = Math.min(distance[nRow][nCol], distance[r][c] + 1);
                    q.add(new int[] { nRow, nCol, d + 1 });
                }
            }
        }
        return distance;

    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }

    // Without using the visited array and not storing the distance also
    public int[][] updateMatrix_Optimal(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] distance = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    q.add(new int[] { i, j });
                } else {
                    distance[i][j] = (int) (1e9);
                }
            }
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for (int i = 0; i < 4; i++) {
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && distance[nRow][nCol] > distance[r][c] + 1) {
                    distance[nRow][nCol] = distance[r][c] + 1;
                    q.add(new int[] { nRow, nCol });
                }
            }
        }
        return distance;

    }
}
