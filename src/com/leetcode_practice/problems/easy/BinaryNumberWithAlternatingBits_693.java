package com.leetcode_practice.problems.easy;

public class BinaryNumberWithAlternatingBits_693 {
    public boolean hasAlternatingBits(int n) {
        int lastDigit = n % 2;
        n /= 2;
        while (n > 0) {
            if (n % 2 == lastDigit)
                return false;
            else
                lastDigit = n % 2;
            n /= 2;
        }
        return true;
    }

    public boolean hasAlternatingBits_optimal(int n) {
        // if n has all bits alternate then n ^ (n >> 1) will give number with all 1's
        int x = n ^ (n >> 1);
        // If all 1's then x & x+1 will be 0
        return (x & (x + 1)) == 0;
    }
}
