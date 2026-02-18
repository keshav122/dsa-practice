package com.leetcode_practice.problems.easy;

public class ReverseBits_190 {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // shift result to left
            result <<= 1;
            result |= (n & 1);
            n >>>= 1;
        }
        return result;
    }
}
