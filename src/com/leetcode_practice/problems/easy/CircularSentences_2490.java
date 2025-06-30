package com.leetcode_practice.problems.easy;

public class CircularSentences_2490 {
    public boolean isCircularSentence(String sentence) {
        int n = sentence.length();
        if (sentence.charAt(0) == sentence.charAt(n - 1)) {
            for (int i = 0; i < n; i++) {
                if (sentence.charAt(i) == ' ' && sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
