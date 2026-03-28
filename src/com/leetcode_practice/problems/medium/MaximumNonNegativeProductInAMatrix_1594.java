package com.leetcode_practice.problems.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumNonNegativeProductInAMatrix_1594 {

    public int maxProductPath(int[][] grid) {
        int MOD = 1_000_000_007;
        return (int) (f(0, 0, grid).max % MOD);
    }

    private Pair f(int r, int c, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (r < 0 || r >= n || c < 0 || c >= m)
            return new Pair(-1, -1);
        int curr = grid[r][c];
        Pair right = f(r, c + 1, grid);
        Pair down = f(r + 1, c, grid);
        List<Long> candidates = Arrays.asList(curr * right.max, curr * right.min, curr * down.max, curr * down.min);
        Collections.sort(candidates);
        long maxAns = candidates.get(candidates.size() - 1);
        long minAns = candidates.get(0);
        return new Pair(minAns, maxAns);
    }

    static class Pair {
        long min;
        long max;

        public Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }
}
