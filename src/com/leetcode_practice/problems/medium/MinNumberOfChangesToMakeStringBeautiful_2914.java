package com.leetcode_practice.problems.medium;

public class MinNumberOfChangesToMakeStringBeautiful_2914 {
    public int minChanges(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n - 1; i += 2) {
            String substring = s.substring(i, i + 2);
            if (substring.contentEquals("00") || substring.contentEquals("11")) {
                continue;
            } else {
                count++;
            }
        }
        return count;
    }

    public int minChanges_better(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
