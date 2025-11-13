package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class OnesAndZeroes_474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        Counter[] counter = new Counter[len];
        int it = 0;
        for (String str : strs) {
            int zero = 0, one = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0')
                    zero++;
                else
                    one++;
            }
            counter[it++] = new Counter(zero, one);
        }
        int[][][] dp = new int[len][m + 1][n + 1];
        for (int[][] grid : dp) {
            for (int[] row : grid) {
                Arrays.fill(row, -1);
            }
        }
        return maxCount(len - 1, counter, m, n, dp);
    }

    private int maxCount(int index, Counter[] counter, int zeroCount, int oneCount, int[][][] dp) {
        if (index == 0) {
            if (counter[0].zC <= zeroCount && counter[0].oC <= oneCount) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[index][zeroCount][oneCount] != -1)
            return dp[index][zeroCount][oneCount];
        int take = Integer.MIN_VALUE;
        if (counter[index].zC <= zeroCount && counter[index].oC <= oneCount) {
            take = 1 + maxCount(index - 1, counter, zeroCount - counter[index].zC, oneCount - counter[index].oC, dp);
        }

        int notTake = maxCount(index - 1, counter, zeroCount, oneCount, dp);
        return dp[index][zeroCount][oneCount] = Math.max(take, notTake);
    }

    public int findMaxForm_better(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zero = 0, one = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    zero++;
                else
                    one++;
            }

            // Loop backwards to prevent overcounting
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zero][j - one]);
                }
            }
        }

        return dp[m][n];
    }

class Counter {
    int zC; // zero Counter
    int oC; // one Counter

    Counter(int zC, int oC) {
        this.zC = zC;
        this.oC = oC;
    }
}
