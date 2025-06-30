package com.dsa_series.roadmap.recursion.FAQs_Hard;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public List<String> findPath(int[][] grid) {
        int n = grid.length;
        List<String> paths = new ArrayList<>();
        if (grid[0][0] == 0 || grid[n - 1][n - 1] == 0) {
            paths.add("-1");
            return paths;
        }
        String str = "";
        generatePaths(0, 0, paths, str, n, grid);
        if (paths.isEmpty()) {
            paths.add("-1");
            return paths;
        }
        return paths;
    }

    private void generatePaths(int row, int col, List<String> paths, String str, int n, int[][] grid) {
        if (row == n - 1 && col == n - 1) {
            paths.add(str);
            str = "";
            return;
        }
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == 0) {
            return;
        }
        // We must not visit the same cell twice
        grid[row][col] = 0;
        // call Left
        generatePaths(row, col - 1, paths, str + "L", n, grid);
        // call Right
        generatePaths(row, col + 1, paths, str + "R", n, grid);
        // call down
        generatePaths(row + 1, col, paths, str + "D", n, grid);
        // call Up
        generatePaths(row - 1, col, paths, str + "U", n, grid);
        grid[row][col] = 1;
    }
}
