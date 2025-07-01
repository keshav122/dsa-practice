package com.leetcode_practice.problems.easy;

public class FindTheOriginallyTypedString_3330 {
    public int possibleStringCount(String word) {
        int totalLength = 1;
        char currentChar = word.charAt(0);
        int currentCharCount = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == currentChar) {
                currentCharCount++;
            } else {
                totalLength += currentCharCount - 1;
                currentChar = word.charAt(i);
                currentCharCount = 1;
            }
        }
        totalLength += currentCharCount - 1;
        return totalLength;
    }
}
