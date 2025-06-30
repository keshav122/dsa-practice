package com.roadmap.beginnerproblems.basic_recursion;

public class StringIsPalindrome {
    public boolean palindromeCheck(String s) {
        if (s.length() <= 1) {
            return true;
        }
        return palindromeCheck(s, 0, s.length() - 1);
    }

    private boolean palindromeCheck(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return true;
        }
        boolean smallSubstringCheck = palindromeCheck(s, startIndex + 1, endIndex - 1);
        if (smallSubstringCheck) {
            return s.charAt(startIndex) == s.charAt(endIndex);
        }
        return false;
    }
}
