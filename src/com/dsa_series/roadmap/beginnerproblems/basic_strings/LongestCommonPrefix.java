package com.dsa_series.roadmap.beginnerproblems.basic_strings;

import java.util.Arrays;

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

    public String longestCommonPrefix_better(String[] str) {
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < str[0].length(); i++) {
            char ch = str[0].charAt(i);
            for (String s : str) {
                if (s.length() == i || s.charAt(i) != ch) {
                    return prefix.toString();
                }
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }

    public String longestCommonPrefix_sorting(String[] str) {
        Arrays.sort(str);
        String min = str[0];
        String max = str[str.length - 1];
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < min.length(); i++) {
            if (min.charAt(i) != max.charAt(i))
                return prefix.toString();
            prefix.append(min.charAt(i));
        }
        return prefix.toString();
    }
}
