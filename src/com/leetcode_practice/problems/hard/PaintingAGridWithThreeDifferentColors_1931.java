package com.leetcode_practice.problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaintingAGridWithThreeDifferentColors_1931 {
    int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        // Generate Column States
        // Arguments - Prev String, Prev Character, Initial length, Max Length
        List<String> columnStates = new ArrayList<>();
        generateColumnStates("", '#', 0, m, columnStates);

        int result = 0;
        int[][] dp = new int[columnStates.size()][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < columnStates.size(); i++) {
            result = (result + (solve(columnStates, i, n - 1, m, dp) % MOD)) % MOD;
        }

        return result;
    }

    private int solve(List<String> columnStates, int prevStateIndex, int remainCols, int m, int[][] dp) {
        if (remainCols == 0) {
            return 1;
        }
        if (dp[prevStateIndex][remainCols] != -1)
            return dp[prevStateIndex][remainCols];
        int ways = 0;
        String prevState = columnStates.get(prevStateIndex);
        for (int i = 0; i < columnStates.size(); i++) {
            if (i == prevStateIndex)
                continue;
            String currState = columnStates.get(i);
            boolean valid = true;
            for (int j = 0; j < m; j++) {
                if (currState.charAt(j) == prevState.charAt(j)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ways = (ways + solve(columnStates, i, remainCols - 1, m, dp) % MOD) % MOD;
            }
        }
        return dp[prevStateIndex][remainCols] = ways;
    }

    private void generateColumnStates(String curr, char prevChar, int l, int m, List<String> columnStates) {
        if (l == m) {
            columnStates.add(curr);
            return;
        }
        char[] colors = { 'R', 'G', 'B' };
        for (char ch : colors) {
            if (ch == prevChar)
                continue;
            generateColumnStates(curr + ch, ch, l + 1, m, columnStates);
        }
    }

}
