package com.leetcode_practice.problems.easy;

public class RotateString_796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        String concat = s + s;
        for (int i = 0; i < concat.length() - goal.length() + 1; i++) {
            if (concat.charAt(i) == goal.charAt(0)) {
                String subStr = concat.substring(i, i + goal.length());
                if (subStr.equals(goal))
                    return true;
            }
        }
        return false;
    }

    public boolean rotateString_better(String s, String goal) {
        if (s.length() != goal.length())
            return false;

        return (s + s).contains(goal);
    }
}
