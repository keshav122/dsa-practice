package com.leetcode_practice.problems.medium;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int sI = 0, eI = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    sI = i;
                    eI = j;
                }
            }
        }
        return s.substring(sI, eI + 1);
    }

    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
