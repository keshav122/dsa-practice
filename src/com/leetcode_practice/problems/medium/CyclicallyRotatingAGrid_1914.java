package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class CyclicallyRotatingAGrid_1914 {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> arr = new ArrayList<>();
            int top = layer;
            int bottom = m - 1 - layer;
            int left = layer;
            int right = n - 1 - layer;

            // top row
            for (int j = left; j <= right; j++) {
                arr.add(grid[top][j]);
            }

            // right column
            for (int j = top + 1; j <= bottom; j++) {
                arr.add(grid[j][right]);
            }

            // bottom row
            for (int j = right - 1; j >= left; j--) {
                arr.add(grid[bottom][j]);
            }

            // left column
            for (int j = bottom - 1; j > top; j--) {
                arr.add(grid[j][left]);
            }

            int len = arr.size();
            int rotate = k % len;
            // counter-clockwise rotation extracted order is clockwise so we left rotate
            List<Integer> rotated = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                rotated.add(arr.get((i + rotate) % len));
            }

            int idx = 0;

            // put back top row
            for (int j = left; j <= right; j++) {
                grid[top][j] = rotated.get(idx++);
            }

            // put back right column
            for (int j = top + 1; j <= bottom; j++) {
                grid[j][right] = rotated.get(idx++);
            }

            // bottom row
            for (int j = right - 1; j >= left; j--) {
                grid[bottom][j] = rotated.get(idx++);
            }

            // left column
            for (int j = bottom - 1; j > top; j--) {
                grid[j][left] = rotated.get(idx++);
            }

        }

        return grid;

    }
}
