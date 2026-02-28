package com.leetcode_practice.problems.medium;

import java.util.HashSet;
import java.util.Set;

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

    public boolean hasAllCodes_RollingBitMask(String s, int k) {
        int n = s.length();
        if (n < k)
            return false;
        boolean[] seen = new boolean[1 << k];
        int total = 1 << k;
        int count = 0, mask = 0;
        for (int i = 0; i < n; i++) {
            mask = (mask << 1) & (total - 1) | (s.charAt(i) - '0');
            if (i >= k - 1 && !seen[mask]) {
                seen[mask] = true;
                count++;
                if (count == total)
                    return true;
            }
        }
        return false;
    }
}
