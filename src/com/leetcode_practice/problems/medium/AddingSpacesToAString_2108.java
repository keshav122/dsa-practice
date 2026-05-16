package com.leetcode_practice.problems.medium;

public class AddingSpacesToAString_2108 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int strIndex = 0, i = 0, n = spaces.length, len = s.length();
        while (strIndex < len) {
            if (i < n && spaces[i] == strIndex) {
                sb.append(" ");
                i++;
            } else {
                sb.append(s.charAt(strIndex));
                strIndex++;
            }
        }
        return sb.toString();
    }
}
