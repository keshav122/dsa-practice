package com.dsa_series.roadmap.graphs.traversal_problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class NumberOfDistinctIslands {
    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, -1, 0, 1 };

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    bfs(i, j, grid, vis, set);
                }
            }
        }
        return set.size();
    }

    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n)
            return false;
        if (j < 0 || j >= m)
            return false;
        return true;
    }

    private void bfs(int row, int col, int[][] grid, boolean[][] vis, Set<List<String>> set) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        List<String> shape = new ArrayList<>();
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            vis[r][c] = true;
            shape.add((r - row) + "," + (c - col));
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];
                if (isValid(nRow, nCol, n, m) && !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                    vis[nRow][nCol] = true;
                    shape.add((nRow - row) + "," + (nCol - col));
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
        set.add(shape);
    }
}

class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

}

class NumberOfDistinctIslandsByDFS {
    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, -1, 0, 1 };

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    List<String> paths = new ArrayList<>();
                    dfs(i, j, grid, vis, paths, i, j);
                    set.add(paths);
                }
            }
        }
        return set.size();
    }

    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n)
            return false;
        if (j < 0 || j >= m)
            return false;
        return true;
    }

    private void dfs(int row, int col, int[][] grid, boolean[][] vis, List<String> paths, int baseRow, int baseCol) {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;
        paths.add((row - baseRow) + "," + (col - baseCol));
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (isValid(nRow, nCol, n, m) && !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, grid, vis, paths, baseRow, baseCol);
            }
        }
    }
}