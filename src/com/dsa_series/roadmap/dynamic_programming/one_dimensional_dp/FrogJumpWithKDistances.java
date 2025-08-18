package com.dsa_series.roadmap.dynamic_programming.one_dimensional_dp;

import java.util.Arrays;

public class FrogJumpWithKDistances {
    public int frogJump(int[] heights, int k) {
        return frogJump(heights, heights.length - 1);
    }

    public int frogJump(int[] heights, int k, int index) {
        if (index == 0)
            return 0;

        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (i <= index) {
                int dist = frogJump(heights, k, index - i) + Math.abs(heights[index] - heights[index - i]);
                minDist = Math.min(dist, minDist);
            }
        }
        return minDist;
    }

    public int frogJump_Memoization(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJump(heights, heights.length - 1, k, dp);
    }

    private int frogJump(int[] heights, int index, int k, int[] dp) {
        if (index == 0)
            return 0;

        if (dp[index] != -1)
            return dp[index];
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (i <= index) {
                int dist = frogJump(heights, index - i, k, dp) + Math.abs(heights[index] - heights[index - i]);
                minDist = Math.min(dist, minDist);
            }
        }
        return dp[index] = minDist;
    }

    public int frogJump_Tabulation(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (j <= i) {
                    int dist = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minDist = Math.min(dist, minDist);
                }
            }
            dp[i] = minDist;
        }

        return dp[n - 1];
    }

    public int frogJump_Tabulation_SpaceOptimised(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (j <= i) {
                    int dist = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minDist = Math.min(dist, minDist);
                }
            }
            dp[i] = minDist;
        }

        return dp[n - 1];
    }

}
