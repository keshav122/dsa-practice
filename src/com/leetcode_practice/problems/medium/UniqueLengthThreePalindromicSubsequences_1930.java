package com.leetcode_practice.problems.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueLengthThreePalindromicSubsequences_1930 {

    public int countPalindromicSubsequence(String s) {
        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];

        for (char ch = 'a'; ch <= 'z'; ch++) {
            int firstIndex = -1, lastIndex = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    if (firstIndex == -1) {
                        firstIndex = i;
                    }
                    lastIndex = i;
                }
            }
            firstOcc[ch - 'a'] = firstIndex;
            lastOcc[ch - 'a'] = lastIndex;
        }
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (firstOcc[i] >= 0 && lastOcc[i] >= 0 && firstOcc[i] < lastOcc[i]) {
                Set<Character> set = new HashSet<>();
                for (int ind = firstOcc[i] + 1; ind < lastOcc[i]; ind++) {
                    set.add(s.charAt(ind));
                }
                sum += set.size();
            }
        }
        return sum;
    }

    public int countPalindromicSubsequence_better(String s) {
        int[] firstOcc = new int[26];
        int[] lastOcc = new int[26];
        Arrays.fill(firstOcc, -1);
        Arrays.fill(lastOcc, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (firstOcc[index] == -1) {
                firstOcc[index] = i;
            }
            lastOcc[index] = i;
        }

        int count = 0;
        for (int c = 0; c < 26; c++) {
            if (firstOcc[c] >= 0 && lastOcc[c] >= 0 && firstOcc[c] < lastOcc[c]) {
                boolean[] seen = new boolean[26];
                for (int i = firstOcc[c] + 1; i < lastOcc[c]; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }

                for (boolean b : seen) {
                    if (b)
                        count++;
                }
            }
        }
        return count;
    }
}
