package com.leetcode-practice.problems.easy;

public class DeleteCharactersToMakeFancyString_1957 {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char currChar = s.charAt(0);
        int currCharCount = 1;
        sb.append(currChar);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currChar) {
                currCharCount++;
                if (currCharCount < 3) {
                    sb.append(currChar);
                }
            } else {
                currChar = s.charAt(i);
                currCharCount = 1;
                sb.append(currChar);
            }
        }
        return sb.toString();
    }
}
