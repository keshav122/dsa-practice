package com.roadmap.graphs.traversal_problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }

    private void bfs(int row, int col, boolean[][] vis, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        while (!q.isEmpty()) {
            int curRow = q.peek().first;
            int curCol = q.peek().second;
            q.poll();
            for (int deltaRow = -1; deltaRow <= 1; deltaRow++) {
                for (int deltaCol = -1; deltaCol <= 1; deltaCol++) {
                    int nRow = curRow + deltaRow;// neighbour Row
                    int nCol = curCol + deltaCol;// neighbour Col

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol]
                            && grid[nRow][nCol] == '1') {
                        vis[nRow][nCol] = true;
                        q.add(new Pair(nRow, nCol));
                    }
                }
            }
        }
    }
}

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
