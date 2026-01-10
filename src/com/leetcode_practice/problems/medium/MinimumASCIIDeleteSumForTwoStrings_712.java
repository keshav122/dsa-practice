package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class MinimumASCIIDeleteSumForTwoStrings_712 {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 0, s1, s2, dp);
    }

    private int f(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length() && j == s2.length()) {
            return 0;
        } else if (i >= s1.length() && j < s2.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) {
                sum += (int) (s2.charAt(k));
            }
            return sum;
        } else if (i < s1.length() && j >= s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) {
                sum += (int) (s1.charAt(k));
            }
            return sum;
        }
        if (dp[i][j] != -1)
            return dp[i][j];

        int takeBoth = Integer.MAX_VALUE;
        if (s1.charAt(i) == s2.charAt(j)) {
            takeBoth = f(i + 1, j + 1, s1, s2, dp);
        }
        int skipFirst = (int) (s1.charAt(i)) + f(i + 1, j, s1, s2, dp);
        int skipSecond = (int) (s2.charAt(j)) + f(i, j + 1, s1, s2, dp);
        return dp[i][j] = Math.min(takeBoth, Math.min(skipFirst, skipSecond));
    }

    public int minimumDeleteSum_tab(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[n][m] = 0;

        for (int i = m - 1; i >= 0; i--) {
            dp[n][i] = dp[n][i + 1] + s2.charAt(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i][m] + s1.charAt(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                int takeBoth = Integer.MAX_VALUE;
                if (s1.charAt(i) == s2.charAt(j)) {
                    takeBoth = dp[i + 1][j + 1];
                }
                int skipFirst = (int) (s1.charAt(i)) + dp[i + 1][j];
                int skipSecond = (int) (s2.charAt(j)) + dp[i][j + 1];
                return dp[i][j] = Math.min(takeBoth, Math.min(skipFirst, skipSecond));
            }
        }
        return dp[0][0];
    }
}
