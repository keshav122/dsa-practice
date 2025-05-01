package com.roadmap.graphs.traversal_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        fillColor(sr, sc, vis, image, newColor);
        return image;
    }

    private void fillColor(int sr, int sc, boolean[][] vis, int[][] image, int newColor) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        int n = image.length;
        int m = image[0].length;
        vis[sr][sc] = true;
        int startingPixel = image[sr][sc];

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.poll();
            image[row][col] = newColor;
            // left
            if (col - 1 >= 0 && col - 1 < m && !vis[row][col - 1] && image[row][col - 1] == startingPixel) {
                image[row][col - 1] = newColor;
                vis[row][col - 1] = true;
                q.add(new Pair(row, col - 1));
            }

            // right
            if (col + 1 >= 0 && col + 1 < m && !vis[row][col + 1] && image[row][col + 1] == startingPixel) {
                image[row][col + 1] = newColor;
                vis[row][col + 1] = true;
                q.add(new Pair(row, col + 1));
            }

            // top
            if (row - 1 >= 0 && row - 1 < n && !vis[row - 1][col] && image[row - 1][col] == startingPixel) {
                image[row - 1][col] = newColor;
                vis[row - 1][col] = true;
                q.add(new Pair(row - 1, col));
            }

            // bottom
            if (row + 1 >= 0 && row + 1 < n && !vis[row + 1][col] && image[row + 1][col] == startingPixel) {
                image[row + 1][col] = newColor;
                vis[row + 1][col] = true;
                q.add(new Pair(row + 1, col));
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

class FloodFillAlgorithmUsingDFS {

    private int[] delRow = { -1, 0, 1, 0 };
    private int[] delCol = { 0, 1, 0, -1 };

    private boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n)
            return false;
        if (j < 0 || j >= m)
            return false;

        return true;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];
        // To store the updated image
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            ans[i] = Arrays.copyOf(image[i], image[i].length);
        }
        dfs(sr, sc, ans, image, newColor, initialColor);
        return ans;
    }

    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int initialColor) {
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (isValid(nRow, nCol, n, m) && image[nRow][nCol] == initialColor && ans[nRow][nCol] != newColor) {
                dfs(nRow, nCol, ans, image, newColor, initialColor);
            }
        }
    }
}