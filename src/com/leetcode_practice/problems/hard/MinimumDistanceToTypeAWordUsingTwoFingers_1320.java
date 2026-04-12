package com.leetcode_practice.problems.hard;

import java.util.Arrays;

public class MinimumDistanceToTypeAWordUsingTwoFingers_1320 {

    int dist(int a, int b) {
        int r1 = a / 6, c1 = a % 6;
        int r2 = b / 6, c2 = b % 6;
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        // dp[j] = min cost where free finger is at j
        int[] dp = new int[26];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // initial: before typing anything
        for (int i = 0; i < 26; i++)
            dp[i] = 0;

        for (int i = 1; i < n; i++) {
            int curr = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';

            int[] newDp = new int[26];
            Arrays.fill(newDp, Integer.MAX_VALUE);

            for (int j = 0; j < 26; j++) {
                if (dp[j] == Integer.MAX_VALUE)
                    continue;

                // Option 1: same finger
                newDp[j] = Math.min(newDp[j], dp[j] + dist(prev, curr));

                // Option 2: free finger types
                newDp[prev] = Math.min(newDp[prev], dp[j] + dist(j, curr));
            }

            dp = newDp;
        }

        int res = Integer.MAX_VALUE;
        for (int x : dp)
            res = Math.min(res, x);
        return res;
    }
}
