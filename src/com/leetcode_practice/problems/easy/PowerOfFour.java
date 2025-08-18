package com.leetcode_practice.problems.easy;

public class PowerOfFour {
    public boolean isPowerOfFour_iterative(int n) {
        if (n == 1)
            return true;
        if (n < 0)
            return false;
        long base = 1;
        for (int i = 1; i <= 16; i++) {
            base *= 4;
            if (n == base)
                return true;
        }
        return false;
    }

    public boolean isPowerOfFour(int n) {
        if (n == 1)
            return true;
        if (n <= 0)
            return false;
        if (n % 4 != 0) {
            return false;
        }
        return isPowerOfFour(n / 4);
    }

    public boolean isPowerOfFour_Optimal(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }

    public boolean isPowerOfFour_OptimalBitwise(int n) {
        if (n <= 0)
            return false;

        // Check power of 2 (only one bit set)
        if ((n & (n - 1)) != 0)
            return false;

        // Check that the single set bit is at an even position (0-based index)
        // 0x55555555 = binary 01010101010101010101010101010101
        // This mask has 1's in all even bit positions
        return (n & 0x55555555) != 0;
    }

}
