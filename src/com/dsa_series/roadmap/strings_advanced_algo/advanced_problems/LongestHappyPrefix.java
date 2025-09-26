package com.dsa_series.roadmap.strings_advanced_algo.advanced_problems;

public class LongestHappyPrefix {
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

    public String lps(String s) {
        int[] LPS = computeLPS(s);
        return s.substring(0, LPS[s.length() - 1]);
    }
}
