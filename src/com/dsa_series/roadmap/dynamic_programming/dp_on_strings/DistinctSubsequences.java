/*Author: keshav122 */
package com.dsa_series.roadmap.dynamic_programming.dp_on_strings;

import java.util.Arrays;

public class DistinctSubsequences {
    public static final int MODULO = (int) (1e9) + 7;

    public int distinctSubsequences(String s, String t) {
        return f(s.length() - 1, t.length() - 1, s, t);
    }

    private int f(int i, int j, String s, String t) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (s.charAt(i) == t.charAt(j)) {
            return f(i - 1, j - 1, s, t) + f(i - 1, j, s, t);
        }
        return f(i - 1, j, s, t);
    }

    public int distinctSubsequences_M(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f(n - 1, m - 1, s, t, dp);
    }

    private int f(int i, int j, String s, String t, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = (f(i - 1, j - 1, s, t, dp) + f(i - 1, j, s, t, dp)) % MODULO;
        }
        return dp[i][j] = f(i - 1, j, s, t, dp) % MODULO;
    }

    public int distinctSubsequences_Tab(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MODULO;
                } else {
                    dp[i][j] = dp[i - 1][j] % MODULO;
                }
            }
        }
        return dp[n][m];
    }

    public int distinctSubsequences_Tab_SO(String s, String t) {
        int MODULO = (int) (1e9) + 7;
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = (prev[j - 1] + prev[j]) % MODULO;
                } else {
                    curr[j] = prev[j] % MODULO;
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    public int distinctSubsequences_Tab_SO_SingleArr(String s, String t) {
        int MODULO = (int) (1e9) + 7;
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m + 1];
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    prev[j] = (prev[j - 1] + prev[j]) % MODULO;
                }
            }
        }
        return prev[m];
    }
}
