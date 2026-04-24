package com.leetcode_practice.contest.biweekly.count_180;

import java.util.Arrays;

public class MaximumValueOfConcatenatedBinarySegments_3897 {
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(Math.abs(nums1[i] - nums0[i]), i);
        }
        Arrays.sort(pairs, (a, b) -> (b.diff - a.diff));

        for (Pair p : pairs) {
            System.out.println(p.diff + " : " + p.idx);
        }
        StringBuilder sb = new StringBuilder();
        for (Pair p : pairs) {
            int index = p.idx;
            sb.append("1".repeat(nums1[index]));
            sb.append("0".repeat(nums0[index]));
        }

        int len = sb.length();
        String s = sb.toString();
        System.out.println(s);
        int val = 0;
        int MOD = 1_000_000_007;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                val = (val + (1 << (len - i - 1)) % MOD) % MOD;
            }

        }
        return val;

    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums0 = { 1, 0 };

        P4 p = new P4();
        System.out.println(p.maxValue(nums1, nums0));
    }

    class Pair {
        int diff;
        int idx;

        Pair(int diff, int idx) {
            this.diff = diff;
            this.idx = idx;
        }
    }
}
