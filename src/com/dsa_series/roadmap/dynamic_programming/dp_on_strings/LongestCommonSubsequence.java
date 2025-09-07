package com.dsa_series.roadmap.dynamic_programming.dp_on_strings;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int lcs(String str1, String str2) {
        return f(str1.length() - 1, str2.length() - 1, str1, str2);
    }

    private int f(int index1, int index2, String str1, String str2) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (str1.charAt(index1) == str2.charAt(index2)) {
            return 1 + f(index1 - 1, index2 - 1, str1, str2);
        }

        return Math.max(f(index1 - 1, index2, str1, str2), f(index1, index2 - 1, str1, str2));
    }

    public int lcs_M(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, str1, str2, dp);
    }

    private int f(int index1, int index2, String str1, String str2, int[][] dp) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (dp[index1][index2] != -1)
            return dp[index1][index2];

        if (str1.charAt(index1) == str2.charAt(index2)) {
            return dp[index1][index2] = 1 + f(index1 - 1, index2 - 1, str1, str2, dp);
        }
        return dp[index1][index2] = Math.max(f(index1 - 1, index2, str1, str2, dp),
                f(index1, index2 - 1, str1, str2, dp));
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
