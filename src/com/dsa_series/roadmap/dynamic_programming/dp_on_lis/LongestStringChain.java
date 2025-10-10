/*Author: keshav122 */
package com.dsa_series.roadmap.dynamic_programming.dp_on_lis;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public int longestStringChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Arrays.fill(dp, 1);
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (checkPossible(words[i], words[prev]) && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }
        return maxi;
    }

    // s1 is greater in size than s2
    private boolean checkPossible(String s1, String s2) {
        if (s1.length() != s2.length() + 1)
            return false;
        int first = 0, second = 0;
        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        return (first == s1.length() && second == s2.length());
    }

    public static void main(String[] args) {
        LongestStringChain l = new LongestStringChain();
        String[] words = { "dog", "dogs", "dots", "dot", "dotsa", "d", "do" };
        l.longestStringChain(words);
    }
}
