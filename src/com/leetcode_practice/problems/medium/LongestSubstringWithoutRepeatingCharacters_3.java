package com.leetcode_practice.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, r = 0, maxCount = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (set.contains(c)) {
                while (l < r && s.charAt(l) != c) {
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            } else {
                set.add(s.charAt(r));
                maxCount = Math.max(maxCount, set.size());
            }
            r++;
        }
        return maxCount;
    }
}
