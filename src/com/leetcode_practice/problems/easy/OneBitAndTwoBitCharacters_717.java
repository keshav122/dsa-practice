package com.leetcode_practice.problems.easy;

public class OneBitAndTwoBitCharacters_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while (i < n) {
            if (i == n - 1) {
                return true;
            }
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }

        }
        return false;
    }
}
