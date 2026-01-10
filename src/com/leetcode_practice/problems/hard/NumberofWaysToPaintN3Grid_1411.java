package com.leetcode_practice.problems.hard;

public class NumberofWaysToPaintN3Grid_1411 {
    public int numOfWays(int n) {
        int mod = (int) (1e9) + 7;
        // 2 unique and 1
        long c2 = 6;
        long c3 = 6;
        for (int i = 2; i <= n; i++) {
            long temp = c3;
            c3 = (c2 * 2 + c3 * 2) % mod;
            c2 = (2 * temp + 3 * c2) % mod;
        }
        return (int) ((c3 + c2) % mod);
    }
}
