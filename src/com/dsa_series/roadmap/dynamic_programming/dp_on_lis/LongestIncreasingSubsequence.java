package com.dsa_series.roadmap.dynamic_programming.dp_on_lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int LIS(int[] nums) {
        return f(nums, nums.length, 0, -1);
    }

    private int f(int[] nums, int n, int index, int prevInd) {
        if (index == n)
            return 0;
        int len = f(nums, n, index + 1, prevInd);
        if (prevInd == -1 || nums[index] > nums[prevInd]) {
            len = Math.max(len, 1 + f(nums, n, index + 1, index));
        }
        return len;
    }

    public int LIS_M(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, -1, nums, n, dp);
    }

    private int f(int index, int prevInd, int[] nums, int n, int[][] dp) {
        if (index == n - 1) {
            if (prevInd == -1 || nums[prevInd] < nums[index])
                return 1;
            return 0;
        }
        if (dp[index][prevInd + 1] != -1)
            return dp[index][prevInd + 1];
        int notTake = f(index + 1, prevInd, nums, n, dp);
        int take = 0;
        if (prevInd == -1 || nums[index] > nums[prevInd]) {
            take = 1 + f(index + 1, index, nums, n, dp);
        }
        return dp[index][prevInd + 1] = Math.max(take, notTake);
    }

    public int LIS_tabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int prevInd = i - 1; prevInd >= -1; prevInd--) {
                int len = dp[i + 1][prevInd + 1];
                if (prevInd == -1 || nums[i] > nums[prevInd]) {
                    len = Math.max(len, 1 + dp[i + 1][i + 1]);
                }
                dp[i][prevInd + 1] = len;
            }
        }
        return dp[0][0];
    }

    public int LIS_tabulation_SO(int[] nums) {
        int n = nums.length;
        int[] next = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int[] curr = new int[n + 1];
            for (int prevInd = i - 1; prevInd >= -1; prevInd--) {
                int len = next[prevInd + 1];
                if (prevInd == -1 || nums[i] > nums[prevInd]) {
                    len = Math.max(len, 1 + next[i + 1]);
                }
                curr[prevInd + 1] = len;
            }
            next = curr;
        }
        return next[0];
    }

    // This variation is useful when we want to trace back the LIS
    public int LIS_tabulation_Variation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }

    public int LIS_BinarySearch(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
            } else {
                int ind = Collections.binarySearch(temp, nums[i]);
                if (ind < 0)
                    ind = -(ind + 1);

                temp.set(ind, nums[i]);
            }
        }
        return temp.size();
    }
}
