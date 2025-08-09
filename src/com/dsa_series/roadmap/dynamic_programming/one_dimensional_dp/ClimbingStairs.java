package com.dsa_series.roadmap.dynamic_programming.one_dimensional_dp;

import java.util.Arrays;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 3)
            return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs_memoization(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairs(dp, n);
    }

    private int climbStairs(int[] dp, int n) {
        if (n <= 2) {
            return n;
        }
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = climbStairs(dp, n - 1) + climbStairs(dp, n - 2);
    }

    public int climbStairs_tabulation(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs_tabulation_so(int n) {
        if (n <= 2) {
            return n;
        }

        int prev2 = 1;
        int prev = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
