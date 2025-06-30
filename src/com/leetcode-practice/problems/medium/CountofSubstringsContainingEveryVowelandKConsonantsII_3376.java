package com.leetcode-practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class CountofSubstringsContainingEveryVowelandKConsonantsII_3376 {
    public long countOfSubstrings(String word, int k) {
        int l = 0, r = 0;
        Map<Character, Integer> vowelCount = new HashMap<>();
        int n = word.length();
        long count = 0;
        int consonantCount = 0;
        // Pre-compute next consonant for all indices
        int[] nextConsonant = new int[n];
        int nextConsonantIndex = n;
        for (int i = n - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }
        while (r < n) {
            char c = word.charAt(r);
            if (isVowel(c)) {
                vowelCount.merge(c, 1, Integer::sum);
            } else {
                consonantCount++;
            }

            while (consonantCount > k) {
                char c1 = word.charAt(l);
                if (isVowel(c1)) {
                    vowelCount.put(c1, vowelCount.get(c1) - 1);
                    if (vowelCount.get(c1) == 0) {
                        vowelCount.remove(c1);
                    }
                } else {
                    consonantCount--;
                }
                l++;
            }

            while (l < r && consonantCount == k && vowelCount.keySet().size() == 5) {
                // count the current valid substring, as well as valid substrings produced by
                // appending more vowels
                count += nextConsonant[r] - r;
                char startChar = word.charAt(l);
                if (isVowel(startChar)) {
                    vowelCount.put(startChar, vowelCount.get(startChar) - 1);
                    if (vowelCount.get(startChar) == 0) {
                        vowelCount.remove(startChar);
                    }
                } else {
                    consonantCount--;
                }
                l++;
            }

            r++;
        }

        return count;
    }

    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
