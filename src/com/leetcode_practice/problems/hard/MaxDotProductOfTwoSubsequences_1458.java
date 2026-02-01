package com.leetcode_practice.problems.hard;

import java.util.Arrays;

public class MaxDotProductOfTwoSubsequences_1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 0, nums1, nums2, dp);
    }

    private int f(int ind1, int ind2, int[] nums1, int[] nums2, int[][] dp) {
        if (ind1 == nums1.length || ind2 == nums2.length) {
            return -(int) (1e9);
        }

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        int take = nums1[ind1] * nums2[ind2] + Math.max(0, f(ind1 + 1, ind2 + 1, nums1, nums2, dp));
        int skip1 = f(ind1 + 1, ind2, nums1, nums2, dp);
        int skip2 = f(ind1, ind2 + 1, nums1, nums2, dp);
        return dp[ind1][ind2] = Math.max(take, Math.max(skip1, skip2));
    }

    public int maxDotProduct_tab(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][m] = -(int) (1e9);
        }
        for (int i = 0; i < m; i++) {
            dp[n][i] = -(int) (1e9);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int take = nums1[i] * nums2[j] + Math.max(0, dp[i + 1][j + 1]);
                dp[i][j] = Math.max(take, Math.max(dp[i][j + 1], dp[i + 1][j]));
            }
        }
        return dp[0][0];
    }

    public int maxDotProduct_tab_so(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            prev[i] = -(int) (1e9);
        }
        for (int i = n - 1; i >= 0; i--) {
            curr[m] = -(int) (1e9);
            for (int j = m - 1; j >= 0; j--) {
                int take = nums1[i] * nums2[j] + Math.max(0, prev[j + 1]);
                curr[j] = Math.max(take, Math.max(curr[j + 1], prev[j]));
            }
            prev = curr;
        }
        return prev[0];
    }
}
