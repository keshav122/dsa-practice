package com.leetcode-practice.problems.easy;

public class MaxScoreAfterSplittingString_1422 {
    public int maxScore(String s) {
        int n = s.length();
        int sumOne = 0, sumZero = 0, maxScore = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                sumOne++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0') {
                sumZero++;
            } else {
                sumOne--;
            }
            maxScore = Math.max(maxScore, sumZero + sumOne);
        }
        return maxScore;
    }
}