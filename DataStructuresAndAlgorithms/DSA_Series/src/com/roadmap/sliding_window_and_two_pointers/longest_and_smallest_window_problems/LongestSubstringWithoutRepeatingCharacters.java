package com.roadmap.sliding_window_and_two_pointers.longest_and_smallest_window_problems;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int[] hash = new int[256];
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] == 1) {
                    break;
                }
                int len = j - i + 1;
                maxLen = Math.max(len, maxLen);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxLen;
    }

    public int longestNonRepeatingSubstring_Optimal(String s) {
        int[] hash = new int[256];
        int left = 0, right = 0, length = s.length(), maxLen = 0;
        Arrays.fill(hash, -1);
        while (right < length) {
            if (hash[s.charAt(right)] != -1) {
                left = Math.max(hash[s.charAt(right)] + 1, left);
            }
            int currentLength = right - left + 1;
            maxLen = Math.max(currentLength, maxLen);
            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}
