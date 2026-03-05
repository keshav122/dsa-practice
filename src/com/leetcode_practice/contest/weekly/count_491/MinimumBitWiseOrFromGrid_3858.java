package com.leetcode_practice.contest.weekly.count_491;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Problem Statement : sYou are given a 2D integer array grid of size m x n.

You must select exactly one integer from each row of the grid.

Return an integer denoting the minimum possible bitwise OR of the selected integers from each row. */
//TODO  - solve this one
public class MinimumBitWiseOrFromGrid_3858 {
    public int minimumOR(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int n = grid.length;
        int m = grid[0].length;
        if (n == 1)
            return grid[0][0];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int lastOr = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int curr = grid[i + 1][0] | grid[i][j];
                if (curr < lastOr) {
                    lastOr = curr;
                } else {
                    set.add(grid[i][j - 1]);
                    break;
                }
            }
        }
        int ans = 0;
        for (Integer it : set) {
            ans = (ans | it);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 5 }, { 2, 4 } };
        MinimumBitWiseOrFromGrid_3858 m = new MinimumBitWiseOrFromGrid_3858();
        System.out.println(m.minimumOR(grid));
    }
}
