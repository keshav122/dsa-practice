package com.leetcode_practice.problems.medium;

public class CheckIfAStringContainsAllBinaryNodesOfSizeK_1461 {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        int l = 0, r = 0, n = s.length();
        while (r < n) {
            if (r - l + 1 == k) {
                set.add(s.substring(l, r + 1));
            }
            if (r - l + 1 == k + 1) {
                l++;
                set.add(s.substring(l, r + 1));
            }
            r++;
        }
        long size = (long) Math.pow(2, k);
        return set.size() == size;
    }
}
