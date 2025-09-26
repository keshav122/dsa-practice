package com.dsa_series.roadmap.strings_advanced_algo.advanced_problems;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    public List<Integer> search(String text, String pattern) {
        String s = pattern + '$' + text;
        int[] Z = computeZarray(s);
        int n = text.length(), m = pattern.length();
        List<Integer> ans = new ArrayList<>();
        for (int i = m + 1; i < s.length(); i++) {
            if (Z[i] == m)
                ans.add(i - (m + 1));
        }
        return ans;
    }

    private int[] computeZarray_BF(String s) {
        int n = s.length();
        int[] Z = new int[n];
        for (int i = 1; i < n; i++) {
            while (i + Z[i] < n && s.charAt(i + Z[i]) == s.charAt(Z[i])) {
                Z[i]++;
            }
        }
        return Z;
    }

    private int[] computeZarray(String s) {
        int n = s.length();
        int[] Z = new int[n];
        // Pointers to mark the window
        int l = 0, r = 0;
        // For every character
        for (int i = 1; i < n; i++) {
            // Out of window
            if (i > r) {
                while (i + Z[i] < n && s.charAt(i + Z[i]) == s.charAt(Z[i])) {
                    Z[i]++;
                }
            } else {
                if (i + Z[i - l] <= r)
                    Z[i] = Z[i - l];
                else {
                    Z[i] = r - i + 1;// Take the answer till boundary
                    // Start matching beyond boundary using brute force
                    while (i + Z[i] < n && s.charAt(i + Z[i]) == s.charAt(Z[i])) {
                        Z[i]++;
                    }
                }
            }
            l = i;
            r = i + Z[i] - 1;

        }
        return Z;
    }
}
