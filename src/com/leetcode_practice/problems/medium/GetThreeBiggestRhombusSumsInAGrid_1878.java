package com.leetcode_practice.problems.medium;

import java.util.TreeSet;

public class GetThreeBiggestRhombusSumsInAGrid_1878 {

    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int k_max = Math.min(Math.min(i, n - 1 - i),
                        Math.min(m - 1 - j, j));
                for (int k = 0; k <= k_max; k++) {
                    int sum = getRhombusSum(grid, i, j, k);
                    set.add(sum);
                    if (set.size() > 3) {
                        set.pollFirst();
                    }
                }

            }
        }
        int size = set.size();
        int[] res = new int[size];
        int idx = size - 1;
        for (Integer it : set) {
            res[idx--] = it;
        }
        return res;
    }

    private int getRhombusSum(int[][] grid, int i, int j, int k) {
        if (k == 0)
            return grid[i][j];
        int sum = 0;
        int r = i - k, c = j;
        // top -right
        for (int t = 0; t < k; t++) {
            sum += grid[r][c];
            r++;
            c++;
        }
        // right -bottom
        for (int t = 0; t < k; t++) {
            sum += grid[r][c];
            r++;
            c--;
        }

        // bottom -left
        for (int t = 0; t < k; t++) {
            sum += grid[r][c];
            r--;
            c--;
        }

        // left -top
        for (int t = 0; t < k; t++) {
            sum += grid[r][c];
            r--;
            c++;
        }
        return ans;
    }

}
