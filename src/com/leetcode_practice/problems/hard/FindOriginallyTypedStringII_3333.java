package com.leetcode_practice.problems.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOriginallyTypedStringII_3333 {

    public int possibleStringCount(String word, int k) {
        int n = word.length();
        int MOD = 1000000007;
        List<Integer> countGroups = new ArrayList<>();
        int i = 0;
        while (i < n) {
            char c = word.charAt(i);
            int count = 0;
            while (i < n && word.charAt(i) == c) {
                count++;
                i++;
            }
            countGroups.add(count);
        }

        int maxLen = n;
        int m = countGroups.size();
        // dp[i][l] = no of ways to use first i groups to form length l sized string.
        int[][] dp = new int[m + 1][maxLen + 1];
        dp[0][0] = 1; // 0 groups to form length 0 => taking empty substring

        for (int j = 1; j <= m; j++) {
            int cnt = countGroups.get(j - 1);
            for (int l = 0; l < maxLen; l++) {
                if (dp[j - 1][l] == 0)
                    continue;
                // We minimum have to take 1 char out of a group
                for (int takeCharacters = 1; takeCharacters <= cnt; takeCharacters++) {
                    if (l + takeCharacters <= maxLen) {
                        dp[j][l + takeCharacters] = (dp[j][l + takeCharacters] + dp[j - 1][l]) % MOD;
                    }
                }
            }
        }

        int ans = 0;
        for (int len = k; len <= maxLen; len++) {
            ans = (ans + dp[m][len]) % MOD;
        }
        return ans;
    }

    public int possibleStringCount_SpaceOptimised(String word, int k) {
        int n = word.length();
        int MOD = 1000000007;
        List<Integer> countGroups = new ArrayList<>();
        int i = 0;
        while (i < n) {
            char c = word.charAt(i);
            int count = 0;
            while (i < n && word.charAt(i) == c) {
                count++;
                i++;
            }
            countGroups.add(count);
        }

        int maxLen = n;
        int[] dp = new int[maxLen + 1];
        dp[0] = 1;

        for (int cnt : countGroups) {
            int[] nextDp = new int[maxLen + 1];
            for (int len = 0; len <= maxLen; len++) {
                if (dp[len] == 0)
                    continue;
                for (int takeCharacters = 1; takeCharacters <= cnt; takeCharacters++) {
                    if (len + takeCharacters <= maxLen) {
                        nextDp[len + takeCharacters] = (nextDp[len + takeCharacters] + dp[len]) % MOD;
                    }
                }
            }
            dp = nextDp;
        }

        int ans = 0;
        for (int len = k; len <= maxLen; len++) {
            ans = (ans + dp[len]) % MOD;
        }
        return ans;
    }

    // Using Prefix Sum Approach
    public int possibleStringCount_MemorySpaceOptimised(String word, int k) {
        int n = word.length();
        int MOD = 1000000007;
        List<Integer> countGroups = new ArrayList<>();
        int i = 0;
        while (i < n) {
            char c = word.charAt(i);
            int count = 0;
            while (i < n && word.charAt(i) == c) {
                count++;
                i++;
            }
            countGroups.add(count);
        }

        int maxLen = n;
        int[] dp = new int[maxLen + 1];
        dp[0] = 1;

        for (int cnt : countGroups) {
            int[] nextDp = new int[maxLen + 1];
            for (int len = 0; len <= maxLen; len++) {
                if (dp[len] == 0)
                    continue;

                int l = len + 1;
                int r = len + cnt + 1;
                if (l <= maxLen) {
                    nextDp[l] = (nextDp[l] + dp[len]) % MOD;
                    if (r <= maxLen) {
                        nextDp[r] = (nextDp[r] - dp[len] + MOD) % MOD;
                    }
                }
            }
            // Take Prefix sum
            for (int j = 1; j <= maxLen; j++) {
                nextDp[j] = (nextDp[j] + nextDp[j - 1]) % MOD;
            }
            dp = nextDp;

        }

        int ans = 0;
        for (int len = k; len <= maxLen; len++) {
            ans = (ans + dp[len]) % MOD;
        }
        return ans;
    }

    // More optimised - Even this is NOT AC - gives TLE
    public int possibleStringCount_OptimalMemorySpaceOptimised(String word, int k) {
        int n = word.length();
        int MOD = 1000000007;
        List<Integer> countGroups = new ArrayList<>();
        int i = 0;
        while (i < n) {
            char c = word.charAt(i);
            int count = 0;
            while (i < n && word.charAt(i) == c) {
                count++;
                i++;
            }
            countGroups.add(count);
        }

        int maxLen = n;
        int[] dp = new int[maxLen + 1];
        dp[0] = 1;
        // Track current maximum achievable length
        int currentMaxLength = 0;
        for (int cnt : countGroups) {
            int[] nextDp = new int[maxLen + 1];
            for (int len = 0; len <= currentMaxLength; len++) {
                if (dp[len] == 0)
                    continue;

                int l = len + 1;
                int r = len + cnt + 1;
                if (l <= maxLen) {
                    nextDp[l] = (nextDp[l] + dp[len]) % MOD;
                    if (r <= maxLen) {
                        nextDp[r] = (nextDp[r] - dp[len] + MOD) % MOD;
                    }
                }
            }
            // Take Prefix sum
            for (int j = 1; j <= Math.min(currentMaxLength + cnt, maxLen); j++) {
                nextDp[j] = (nextDp[j] + nextDp[j - 1]) % MOD;
            }
            dp = nextDp;
            currentMaxLength = Math.min(maxLen, currentMaxLength + cnt);
        }

        int ans = 0;
        for (int len = k; len <= maxLen; len++) {
            ans = (ans + dp[len]) % MOD;
        }
        return ans;
    }

    public int possibleStringCountW1(String word, int k) {
        int MOD = 1000000007;
        int n = word.length();
        List<Integer> groupCounts = new ArrayList<>();
        int count = 1;

        // Create the list of group sizes
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            } else {
                groupCounts.add(count);
                count = 1;
            }
        }
        groupCounts.add(count);

        // Total possible strings (taking at least 1 from each group)
        long totalWays = 1;
        for (int cnt : groupCounts) {
            totalWays = (totalWays * cnt) % MOD;
        }

        int m = groupCounts.size();
        // If groups >= k, we can form length >= k without any restriction
        if (m >= k) {
            return (int) totalWays;
        }

        // DP: dp[j] = #ways using exactly (j+1) groups
        int[] dp = new int[k];
        int[] prefix = new int[k];

        dp[0] = 1;
        Arrays.fill(prefix, 1);

        for (int size : groupCounts) {
            int[] nextDp = new int[k];

            for (int j = 1; j < k; j++) {
                // Take all previous possible ways
                nextDp[j] = prefix[j - 1];

                // Exclude over-counted cases where the group would exceed its size
                if (j - size - 1 >= 0) {
                    nextDp[j] = (nextDp[j] - prefix[j - size - 1] + MOD) % MOD;
                }
            }

            int[] nextPrefixSum = new int[k];
            nextPrefixSum[0] = nextDp[0];
            for (int j = 1; j < k; j++) {
                nextPrefixSum[j] = (nextPrefixSum[j - 1] + nextDp[j]) % MOD;
            }

            dp = nextDp;
            prefix = nextPrefixSum;
        }

        return (int) ((totalWays - prefix[k - 1] + MOD) % MOD);

    }
}
