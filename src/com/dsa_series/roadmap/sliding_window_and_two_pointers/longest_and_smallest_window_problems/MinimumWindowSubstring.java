package com.dsa_series.roadmap.sliding_window_and_two_pointers.longest_and_smallest_window_problems;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int n = s.length();
        int minLen = Integer.MAX_VALUE, sIndex = -1;
        for (int i = 0; i < n; i++) {
            int[] hash = new int[256];
            int count = 0;
            for (int j = 0; j < t.length(); j++) {
                hash[t.charAt(j)]++;
            }
            for (int j = i; j < n; j++) {
                if (hash[s.charAt(j)] > 0) {
                    count++;
                }
                hash[s.charAt(j)]--;
                if (count == t.length()) {
                    if ((j - i + 1) < minLen) {
                        minLen = j - i + 1;
                        sIndex = i;
                    }
                    break;
                }
            }
        }

        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }

    public String minWindow_optimal(String s, String t) {
        int n = s.length(), m = t.length(), count = 0, l = 0, r = 0;
        int minLen = Integer.MAX_VALUE, sIndex = -1;
        int[] hash = new int[256];
        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }
        while (r < n) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
            while (count == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
