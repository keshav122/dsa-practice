package com.dsa_series.roadmap.graphs.traversal_problems;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHavingOne {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[][] distance = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        // store all the 1s in the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int[] delRow = { 0, 1, 0, -1 };
        int[] delCol = { 1, 0, -1, 0 };
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int d = q.peek().dist;
            q.poll();
            distance[r][c] = d;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int nRow = r + delRow[i];
                    int nCol = c + delCol[i];

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 0
                            && vis[nRow][nCol] == 0) {
                        q.add(new Pair(nRow, nCol, d + 1));
                        vis[nRow][nCol] = 1;
                    }
                }
            }
        }
        return distance;
    }
}

class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
