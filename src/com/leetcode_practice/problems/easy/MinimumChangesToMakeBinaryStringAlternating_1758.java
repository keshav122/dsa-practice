package com.leetcode_practice.problems.easy;

public class MinimumChangesToMakeBinaryStringAlternating_1758 {

    public int minOperations(String s) {
        int n = s.length();
        int startingWithZero = 0, startingWithOne = 0;
        char zero = '0';
        char one = '1';
        for (int i = 0; i < n; i++) {
            if (zero != s.charAt(i)) {
                startingWithZero++;
            }
            if (one != s.charAt(i)) {
                startingWithOne++;
            }
            zero = (zero == '0') ? '1' : '0';
            one = (one == '0') ? '1' : '0';
        }
        return Math.min(startingWithZero, startingWithOne);
    }
}
