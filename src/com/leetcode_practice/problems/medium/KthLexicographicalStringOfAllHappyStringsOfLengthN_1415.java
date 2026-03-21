package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLexicographicalStringOfAllHappyStringsOfLengthN_1415 {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        f(n, happyStrings, sb, 'z');
        if (happyStrings.size() < k) {
            return "";
        }
        Collections.sort(happyStrings);
        return happyStrings.get(k - 1);
    }

    private void f(int n, List<String> happyStrings, StringBuilder sb, char lastChar) {
        if (sb.length() == n) {
            happyStrings.add(sb.toString());
            return;
        }

        if (lastChar != 'a') {
            sb.append('a');
            f(n, happyStrings, sb, 'a');
            sb.deleteCharAt(sb.length() - 1);
        }
        if (lastChar != 'b') {
            sb.append('b');
            f(n, happyStrings, sb, 'b');
            sb.deleteCharAt(sb.length() - 1);
        }
        if (lastChar != 'c') {
            sb.append('c');
            f(n, happyStrings, sb, 'c');
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String getHappyString_Optimals(int n, int k) {
        int total = 3 * (1 << (n - 1));
        if (k > total)
            return "";
        StringBuilder res = new StringBuilder();
        char prev = '#';
        for (int i = 0; i < n; i++) {
            for (char ch : new char[] { 'a', 'b', 'c' }) {
                if (ch == prev)
                    continue;
                int remaining = n - i - 1;
                int count = 1 << remaining;
                if (k > count) {
                    k -= count;
                } else {
                    res.append(ch);
                    prev = ch;
                    break;
                }
            }
        }
        return res.toString();
    }
}
