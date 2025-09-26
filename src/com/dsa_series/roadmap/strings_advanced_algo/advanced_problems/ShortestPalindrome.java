package com.dsa_series.roadmap.strings_advanced_algo.advanced_problems;

public class ShortestPalindrome {
    private int[] computeLPS(String s) {
        int n = s.length();
        int[] LPS = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                LPS[i] = j + 1;
                i++;
                j++;
            } else {
                while (j > 0 && s.charAt(j) != s.charAt(i)) {
                    j = LPS[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    LPS[i] = j + 1;
                    j++;
                }
                i++;
            }
        }
        return LPS;
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        String reversedString = new StringBuilder(s).reverse().toString();
        String str = s + '$' + reversedString;
        int[] LPS = computeLPS(str);
        int num = n - LPS[str.length() - 1];
        return reversedString.substring(0, num) + s;
    }

}
