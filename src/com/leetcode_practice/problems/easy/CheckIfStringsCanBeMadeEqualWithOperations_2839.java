package com.leetcode_practice.problems.easy;

public class CheckIfStringsCanBeMadeEqualWithOperations_2839 {
    public boolean canBeEqual(String s1, String s2) {
        for (int i = 0; i < 4; i++) {
            char ch = s1.charAt(i);
            if (s2.charAt(i) == ch)
                continue;
            if ((i >= 2 && s2.charAt(i - 2) == ch) || (i < 2 && s2.charAt(i + 2) == ch)) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    // This pattern focused that the elements can be equal only at specific
    // positions
    public boolean canBeEqual_better(String s1, String s2) {
        return matches(s1.charAt(0), s2.charAt(0), s1.charAt(2), s2.charAt(2)) &&
                matches(s1.charAt(1), s2.charAt(1), s1.charAt(3), s2.charAt(3));
    }

    private boolean matches(char a, char b, char c, char d) {
        return (a == b && c == d) || (a == d && b == c);
    }
}
