package com.dsa_series.roadmap.dynamic_programming.dp_on_strings;

import java.util.Arrays;

public class EditDistance {
    public int editDistance(String start, String target) {
        return f(start.length() - 1, target.length() - 1, start, target);
    }

    private int f(int i, int j, String start, String target) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (start.charAt(i) == target.charAt(j)) {
            return f(i - 1, j - 1, start, target);
        }

        // f(i,j-1,start,target) - insert , the i doesn't move as we have hypothetically
        // have added a character
        // f(i-1,j,start,target) - delete
        // f(i-1,j-1,start,target) - replace
        return 1 + Math.min(f(i, j - 1, start, target),
                Math.min(f(i - 1, j, start, target), f(i - 1, j - 1, start, target)));
    }

    public int editDistance_M(String start, String target) {
        int n = start.length();
        int m = target.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(start.length() - 1, target.length() - 1, start, target, dp);
    }

    private int f(int i, int j, String start, String target, int[][] dp) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (start.charAt(i) == target.charAt(j)) {
            return f(i - 1, j - 1, start, target, dp);
        }

        // f(i,j-1,start,target) - insert , the i doesn't move as we have hypothetically
        // have added a character
        // f(i-1,j,start,target) - delete
        // f(i-1,j-1,start,target) - replace
        return 1 + Math.min(f(i, j - 1, start, target, dp),
                Math.min(f(i - 1, j, start, target, dp), f(i - 1, j - 1, start, target, dp)));
    }

    public int editDistance_Tab(String start, String target) {
        int n = start.length();
        int m = target.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (start.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    public int editDistance_Tab_So(String start, String target) {
        int n = start.length();
        int m = target.length();
        int[] prev = new int[m + 1];
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (start.charAt(i - 1) == target.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = 1 + Math.min(curr[j - 1],
                            Math.min(prev[j], prev[j - 1]));
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
