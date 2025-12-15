package com.leetcode_practice.contest.weekly.count_480;

import java.util.ArrayList;
import java.util.List;

public class MinimumDeletionsToMakeAlternateSubstring_3777 {
    // Got TLE
    // We need point updates and range updates - Fenwick tree or Segment tree
    // should be used.
    public int[] minDeletions_BF(String s, int[][] queries) {
        char[] sr = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                if (sr[q[1]] == 'A')
                    sr[q[1]] = 'B';
                else
                    sr[q[1]] = 'A';
            } else {
                int count = getDeletions(sr, q[1], q[2]);
                res.add(count);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private int getDeletions(char[] sr, int l, int r) {
        char lastChar = sr[l];
        int count = 0;
        for (int i = l + 1; i <= r; i++) {
            if (sr[i] == lastChar) {
                count++;
            } else {
                lastChar = sr[i];
            }
        }
        return count;
    }
}
