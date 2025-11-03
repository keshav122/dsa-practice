package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands_694 {
    // DelRow and delCol for neighbors
    private int[] delRow = { -1, 0, 1, 0 };
    private int[] delCol = { 0, -1, 0, 1 };

    // Function for DFS traversal of island
    private void dfs(int row, int col, int[][] grid, boolean[][] visited,
            List<String> path, int baseRow, int baseCol) {
        // Get the dimensions of grid
        int n = grid.length;
        int m = grid[0].length;

        /*
         * Add relative position "row,col" of current
         * cell with respect to the base cell
         */
        path.add((row - baseRow) + "," + (col - baseCol));

        // Traverse the 4 neighbors
        for (int i = 0; i < 4; i++) {
            // Get coordinates of new cell
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            // Traverse unvisited, valid, land cell
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && !visited[nRow][nCol]) {
                // Mark the cell as visited
                visited[nRow][nCol] = true;

                // Recursively call DFS for the new cell
                dfs(nRow, nCol, grid, visited, path, baseRow, baseCol);
            }
        }
    }

    /*
     * Function to count the number of
     * distinct islands in the given grid
     */
    public int countDistinctIslands(int[][] grid) {
        // Get the dimensions of grid
        int n = grid.length;
        int m = grid[0].length;

        // 2-D Visited array
        boolean[][] visited = new boolean[n][m];

        // Set to store traversal of unique islands
        Set<List<String>> st = new HashSet<>();

        // Traverse the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /*
                 * Start DFS traversal if an
                 * unvisited land cell is found
                 */
                if (grid[i][j] == 1 && !visited[i][j]) {
                    // Mark the cell as visited
                    visited[i][j] = true;

                    // To store the path of cells
                    List<String> path = new ArrayList<>();

                    // Start DFS traversal from the cell
                    dfs(i, j, grid, visited, path, i, j);

                    // Add the path of explored island to the set
                    st.add(path);
                }
            }
        }

        return st.size();
    }
}

class NumberOfDistinctIslands_694_OptimalSolution {

    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, 1, 0, -1 };

    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder shape = new StringBuilder();
                    dfs(i, j, grid, i, j, shape);
                    shapes.add(shape.toString());
                }
            }
        }
        return shapes.size();

    }

    private void dfs(int row, int col, int[][] grid, int baseRow, int baseCol, StringBuilder shape) {
        int n = grid.length;
        int m = grid[0].length;

        // Mark cell as visited
        grid[row][col] = 0;
        // Encode relative position
        shape.append((row - baseRow) + "," + (col - baseCol) + " ");

        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (isValid(nRow, nCol, n, m) && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, grid, baseRow, baseCol, shape);
            }
        }
    }

    private boolean isValid(int nRow, int nCol, int n, int m) {
        return nRow >= 0 && nRow < n && nCol >= 0 && nCol < m;
    }
}
