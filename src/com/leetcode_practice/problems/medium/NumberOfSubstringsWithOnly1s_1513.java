package com.leetcode_practice.problems.medium;

public class NumberOfSubstringsWithOnly1s_1513 {
    public int numSub_BF(String s) {
        int n = s.length();
        int total = 0;
        int MODULO = (int) (1e9) + 7;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '1')
                continue;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') {
                    total = (total + 1) % MODULO;
                } else {
                    break;
                }
            }
        }
        return total;
    }

    public int numSub_better(String s) {
        int MODULO = (int) (1e9) + 7;
        int total = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
                total = (total + ones) % MODULO;
            } else {
                ones = 0;
            }
        }
        return total;
    }
}
