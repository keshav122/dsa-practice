package com.dsa_series.roadmap.dynamic_programming.dp_on_strings;

public class MinimumInsertionsOrDeletionToConvertStringA_B {
    public int minOperations(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        return n1 + n2 - 2 * (lcs(str1, str2, n1, n2));
    }

    private int lcs(String str1, String str2, int n1, int n2) {
        int[][] dp = new int[n1 + 1][n2 + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public int minOperations_tab_so(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        return n1 + n2 - 2 * (lcs_Tab_SO(str1, str2, n1, n2));
    }

    public int lcs_Tab_SO(String str1, String str2, int n, int m) {
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
