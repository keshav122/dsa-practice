package com.leetcode_practice.problems.easy;

public class FloodFill_733 {
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int og = image[sr][sc];
        if (og == color)
            return image;
        int n = image.length;
        int m = image[0].length;
        dfs(image, sr, sc, og, color, n, m);
        return image;
    }

    private void dfs(int[][] image, int r, int c, int og, int color, int n, int m) {
        image[r][c] = color;
        for (int d = 0; d < 4; d++) {
            int nR = r + dirs[d][0];
            int nC = c + dirs[d][1];
            if (nR >= 0 && nR < n && nC >= 0 && nC < m && image[nR][nC] == og) {
                dfs(image, nR, nC, og, color, n, m);
            }
        }
    }
}
