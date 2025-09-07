package com.dsa_series.roadmap.dynamic_programming.dp_on_strings;

import java.util.Arrays;

public class MinimumInsertionsToMakePalindromicSequence {
    public int minInsertion(String s) {
        return f(0, s.length() - 1, s);
    }

    private int f(int startIndex, int endIndex, String s) {
        if (startIndex >= endIndex) {
            return 0;
        }
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return f(startIndex + 1, endIndex - 1, s);
        }
        return 1 + Math.min(f(startIndex + 1, endIndex, s), f(startIndex, endIndex - 1, s));
    }

    public int minInsertion_M(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, s.length() - 1, s, dp);
    }

    private int f(int startIndex, int endIndex, String s, int[][] dp) {
        if (startIndex >= endIndex) {
            return 0;
        }
        if (dp[startIndex][endIndex] != -1)
            return dp[startIndex][endIndex];
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return dp[startIndex][endIndex] = f(startIndex + 1, endIndex - 1, s, dp);
        }
        return dp[startIndex][endIndex] = 1
                + Math.min(f(startIndex + 1, endIndex, s, dp), f(startIndex, endIndex - 1, s, dp));
    }

    public int minInsertion_tab(String s) {
        int n = s.length();
        // n - lps where lps = lcs(s, rev(s))
        String revString = new StringBuilder(s).reverse().toString();
        return n - lcs_Tab(s, revString);
    }

    public int lcs_Tab(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public int minInsertion_tab_SO(String s) {
        int n = s.length();
        // n - lps where lps = lcs(s, rev(s))
        String revString = new StringBuilder(s).reverse().toString();
        return n - lcs_Tab_SO(s, revString);
    }

    public int lcs_Tab_SO(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[] prev = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
