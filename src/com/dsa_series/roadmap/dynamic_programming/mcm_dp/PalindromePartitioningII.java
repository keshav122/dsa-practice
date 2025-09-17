package com.dsa_series.roadmap.dynamic_programming.mcm_dp;

import java.util.Arrays;

public class PalindromePartitioningII {
    int minCut(String s) {
        int n = s.length();
        // Because we are doing a partition at the end
        return f(0, n, s) - 1;
    }

    private int f(int i, int n, String s) {
        if (i == n)
            return 0;
        int mini = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(s.substring(i, j + 1))) {
                int cost = 1 + f(j + 1, n, s);
                mini = Math.min(mini, cost);
            }
        }
        return mini;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    int minCut_M(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // Because we are doing a partition at the end
        return f(0, n, s, dp) - 1;
    }

    private int f(int i, int n, String s, int[] dp) {
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int mini = Integer.MAX_VALUE;
        for (int j = i; j < n; j++) {
            if (isPalindrome(s.substring(i, j + 1))) {
                int cost = 1 + f(j + 1, n, s, dp);
                mini = Math.min(mini, cost);
            }
        }
        return dp[i] = mini;
    }

    int minCut_Tab(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int mini = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    int cost = 1 + dp[j + 1];
                    mini = Math.min(mini, cost);
                }
            }
            dp[i] = mini;
        }
        // Because we are doing a partition at the end
        return dp[0] - 1;
    }

}
