package com.leetcode_practice.problems.easy;

public class SmallestNumberWithAllBitsSet_3370 {
    public int smallestNumber(int n) {
        if (n == 1)
            return 1;
        int val = 1;
        for (int i = 1; i <= n; i++) {
            val *= 2;
            if (val > n) {
                return val - 1;
            }
        }
        return -1;
    }

    public int smallestNumber_BitManipulation(int n) {
        int val = 1;
        while (val - 1 < n) {
            val <<= 1;
        }
        return val - 1;
    }

    // Highest one bit of (n) returns the greatest power of 2 <= n
    // highestOneBit(3) - 2 ; highestOneBit(4) - 4
    public int smallestNumber_Direct(int n) {
        return Integer.highestOneBit(n) * 2 - 1;
    }
}
