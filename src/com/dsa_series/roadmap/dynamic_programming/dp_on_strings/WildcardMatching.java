package com.dsa_series.roadmap.dynamic_programming.dp_on_strings;

import java.util.Arrays;

public class WildcardMatching {
    private boolean isAllStars(String pat, int i) {
        for (int k = 0; k <= i; k++) {
            if (pat.charAt(k) != '*')
                return false;
        }
        return true;
    }

    public boolean wildCard(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        return f(n - 1, m - 1, str, pat);
    }

    // i denotes actual string index
    // j denotes patterned string index
    private boolean f(int i, int j, String str, String pat) {
        if (i < 0 && j < 0)
            return true;
        if (j < 0 && i >= 0)
            return false;
        if (i < 0 && j >= 0) {
            // If all the remaining characters in the pattern string are '*' then only it
            // can be matched
            isAllStars(pat, j);
        }

        if (str.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?') {
            return f(i - 1, j - 1, str, pat);
        } else if (pat.charAt(j) == '*') {
            // f(i, j - 1, str, pat) - says we count * as nothing (empty string)
            // f(i-1, j, str, pat) - says we count * as first character and then it goes
            // recursively down
            return f(i, j - 1, str, pat) || f(i - 1, j, str, pat);
        } else {
            return false;
        }
    }

    public boolean wildCard_M(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, str, pat, dp);
    }

    // i denotes actual string index
    // j denotes patterned string index
    private boolean f(int i, int j, String str, String pat, int[][] dp) {
        if (i < 0 && j < 0)
            return true;
        if (j < 0 && i >= 0)
            return false;
        if (i < 0 && j >= 0) {
            // If all the remaining characters in the pattern string are '*' then only it
            // can be matched
            return isAllStars(pat, j);
        }

        if (dp[i][j] != -1)
            return dp[i][j] == 1;
        if (str.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?') {
            dp[i][j] = f(i - 1, j - 1, str, pat, dp) ? 1 : 0;
            return dp[i][j] == 1;
        } else if (pat.charAt(j) == '*') {
            // f(i, j - 1, str, pat) - says we count * as nothing (empty string)
            // f(i-1, j, str, pat) - says we count * as first character and then it goes
            // recursively down
            dp[i][j] = f(i, j - 1, str, pat, dp) || f(i - 1, j, str, pat, dp) ? 1 : 0;
            return (dp[i][j] == 1);
        } else {
            return false;
        }
    }

    public boolean wildCard_Tab(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0][i] = isAllStars(pat, i - 1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == pat.charAt(j - 1) || pat.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pat.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public boolean wildCard_tab_so(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        boolean[] prev = new boolean[m + 1];
        prev[0] = true;
        for (int i = 1; i <= m; i++) {
            prev[i] = isAllStars(pat, i - 1);
        }
        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[m + 1];
            curr[0] = false; // non-empty string vs empty pattern
            for (int j = 1; j <= m; j++) {
                if (str.charAt(i - 1) == pat.charAt(j - 1) || pat.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else if (pat.charAt(j - 1) == '*') {
                    curr[j] = curr[j - 1] || prev[j];
                } else {
                    curr[j] = false;
                }
            }
            prev = curr;
        }
        return prev[m];
    }

}
