/*Author: keshav122 */
package com.dsa_series.roadmap.sliding_window_and_two_pointers.longest_and_smallest_window_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int kDistinctChar_BF(String s, int k) {
        int n = s.length(), maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> st = new HashSet<>();
            for (int j = i; j < n; j++) {
                st.add(s.charAt(j));
                if (st.size() <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public int kDistinctChar_Better(String s, int k) {
        int n = s.length(), l = 0, r = 0, maxLen = 0;
        Map<Character, Integer> mpp = new HashMap<>();
        while (r < n) {
            char currentChar = s.charAt(r);
            mpp.put(currentChar, mpp.getOrDefault(currentChar, 0) + 1);

            while (mpp.size() > k) {
                mpp.put(s.charAt(l), mpp.get(s.charAt(l)) - 1);
                if (mpp.get(s.charAt(l)) == 0) {
                    mpp.remove(s.charAt(l));
                }
                l++;
            }

            if (mpp.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public int kDistinctChar_Optimal(String s, int k) {
        int n = s.length(), l = 0, r = 0, maxLen = 0;
        Map<Character, Integer> mpp = new HashMap<>();
        while (r < n) {
            char currentChar = s.charAt(r);
            mpp.put(currentChar, mpp.getOrDefault(currentChar, 0) + 1);

            if (mpp.size() > k) {
                mpp.put(s.charAt(l), mpp.get(s.charAt(l)) - 1);
                if (mpp.get(s.charAt(l)) == 0) {
                    mpp.remove(s.charAt(l));
                }
                l++;
            }

            if (mpp.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }
}
