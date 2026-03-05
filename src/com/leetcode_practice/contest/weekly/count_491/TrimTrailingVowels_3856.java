package com.leetcode_practice.contest.weekly.count_491;

import java.util.Set;

public class TrimTrailingVowels_3856 {
    public String trimTrailingVowels(String s) {
        int n = s.length();
        int i = n - 1;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        while (i >= 0 && set.contains(s.charAt(i))) {
            i--;
        }
        return s.substring(0, i + 1);
    }
}
