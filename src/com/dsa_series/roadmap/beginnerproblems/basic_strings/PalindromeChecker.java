package com.dsa_series.roadmap.beginnerproblems.basic_strings;

public class PalindromeChecker {
    public boolean palindromeCheck(String s) {
        int start = 0;
        int end = s.length() - 1;
        // We keep two pointers start and end and check whether
        // the characters are same.
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
