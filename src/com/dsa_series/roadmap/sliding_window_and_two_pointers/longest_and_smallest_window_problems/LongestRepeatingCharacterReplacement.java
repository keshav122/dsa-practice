/*Author: keshav122 */
package com.dsa_series.roadmap.sliding_window_and_two_pointers.longest_and_smallest_window_problems;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        // Intuition : For a substring AABCAA, the number of required changes
        // are (length - maxFreq) to make it the longest repeating character string
        int n = s.length(), maxLen = 0;
        for (int i = 0; i < n; i++) {
            int[] hash = new int[26];
            int maxFreq = 0;
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
                int changes = (j - i + 1) - maxFreq;
                if (changes <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public int characterReplacement_Better(String s, int k) {
        int n = s.length(), l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int[] hash = new int[26];
        while (r < n) {
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public int characterReplacement_Optimal(String s, int k) {
        int n = s.length(), l = 0, r = 0, maxLen = 0, maxFreq = 0;
        int[] hash = new int[26];
        while (r < n) {
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
            if ((r - l + 1) - maxFreq > k) {
                hash[s.charAt(l) - 'A']--;
                maxFreq = 0;
                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, hash[i]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

}
