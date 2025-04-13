package com.roadmap.graphs.traversal_problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    int[] delRow = { 0, 0, -1, 1 };
    int[] delCol = { -1, 1, 0, 0 };

    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] counter = new int[1];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    bfs(i, j, grid, vis, counter);
                }
            }
        }
        return counter[0];
    }

    private void bfs(int sr, int sc, int[][] grid, boolean[][] vis, int[] counter) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        boolean isBoundary = false;
        vis[sr][sc] = true;
        if (isTerminalNode(sr, sc, n, m)) {
            isBoundary = true;
        }
        int currCtr = 1;
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && !vis[nRow][nCol]) {
                    vis[nRow][nCol] = true;
                    currCtr++;
                    q.add(new Pair(nRow, nCol));
                    if (isTerminalNode(nRow, nCol, n, m)) {
                        isBoundary = true;
                    }
                }
            }
        }

        if (!isBoundary) {
            counter[0] += currCtr;
        }

    }

    boolean isTerminalNode(int i, int j, int n, int m) {
        return (i == 0 || i == n - 1 || j == 0 || j == m - 1);
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

// The optimised approach seeks the idea that we can first push the boundary
// land cells into a
// queue and as the boundary and its connected cells will not contribute to the
// final count
// we can mark them as visited . After that we count the non visited land cells.

class NumberOfEnclavesOptimised {
    public int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        vis[i][j] = true;
                        q.add(new Pair(i, j));
                    }
                }
            }
        }
        int[] delRow = { 0, 0, -1, 1 };
        int[] delCol = { -1, 1, 0, 0 };
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if (nRow >= 0
                        && nRow < n
                        && nCol >= 0
                        && nCol < m
                        && grid[nRow][nCol] == 1
                        && !vis[nRow][nCol]) {
                    vis[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}