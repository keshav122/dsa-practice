package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class ValidParenthesisString_678 {
    public boolean checkValidString_memoizationbased(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 0, s, dp);
    }

    private boolean f(int ind, int count, String s, int[][] dp) {
        if (count < 0)
            return false;
        if (ind == s.length())
            return (count == 0);
        if (dp[ind][count] != -1)
            return (dp[ind][count] == 1);
        boolean ans = false;
        if (s.charAt(ind) == '(') {
            ans = f(ind + 1, count + 1, s, dp);
        } else if (s.charAt(ind) == ')') {
            ans = f(ind + 1, count - 1, s, dp);
        } else {
            for (int i = -1; i <= 1; i++) {
                ans = ans || f(ind + 1, count + i, s, dp);
            }
        }
        dp[ind][count] = ans ? 1 : 0;
        return ans;
    }

    public boolean checkValidString(String s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min++;
                max++;
            } else if (s.charAt(i) == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            if (max < 0)
                return false;
            if (min < 0)
                min = 0;

        }
        return min == 0;
    }
}
