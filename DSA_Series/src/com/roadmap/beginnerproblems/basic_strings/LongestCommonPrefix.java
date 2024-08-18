package com.roadmap.beginnerproblems.basic_strings;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str) {
        StringBuilder prefixString = new StringBuilder();
        // First we find the min length string
        int minLen = 200;
        for (String s : str) {
            minLen = Math.min(s.length(), minLen);
        }
        int j = 0;
        while (j < minLen) {
            char c = str[0].charAt(j);
            for (int i = 1; i < str.length; i++) {
                if (str[i].charAt(j) != c) {
                    return prefixString.toString();
                }
            }
            // We only add it to the final result if it is present in all of the strings
            prefixString.append(c);
            j++;
        }
        return prefixString.toString();
    }
}
