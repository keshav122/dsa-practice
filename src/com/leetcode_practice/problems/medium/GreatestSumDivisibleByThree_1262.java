package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class GreatestSumDivisibleByThree_1262 {

    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = solve(nums, nums.length - 1, 0, dp);
        return ans < 0 ? 0 : ans;
    }

    private int solve(int[] nums, int i, int rem, int[][] dp) {
        if (i < 0) {
            return rem == 0 ? 0 : Integer.MIN_VALUE / 2;
        }
        if (dp[i][rem] != -1)
            return dp[i][rem];

        int num = nums[i];
        int r = num % 3;
        int notTake = solve(nums, i - 1, rem, dp);
        // (finalRem) = (prevRem + r) % 3
        // (prevRem + r) % 3 = rem
        // prevRem + r ≡ rem (mod 3)
        // a % 3 = b means
        // a and b leave the same remainder when divided by 3

        // a ≡ b (mod 3) means
        // a and b leave the same remainder when divided by 3
        // prevRem ≡ rem - r (mod 3)
        // prevRem = (rem - r + 3) % 3 To keep it positive
        int prevRem = (rem - r + 3) % 3;
        int take = num + solve(nums, i - 1, prevRem, dp);
        return dp[i][rem] = Math.max(take, notTake);
    }
}
