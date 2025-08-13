package com.leetcode_practice.problems.easy;

public class PowerOfThree_326 {
    public boolean isPowerOfThree_BF(int n) {
        if (n < 0)
            return false;
        int[] hash = new int[32];
        for (int i = 0; i < 32; i++) {
            hash[i] = i;
        }
        for (int a : hash) {
            if (Math.pow(3, a) == n)
                return true;
        }
        return false;
    }

    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        if (n <= 0 || n % 3 != 0)
            return false;
        return isPowerOfThree(n / 3);
    }

    // Because 1162261467 is the largest power of 3 which falls within the int range
    // Every power of 3 has 3 itself as its only prime factor.
    // If you check largest_power_of_3 % n == 0,
    // it means n can divide the largest power of 3 only if it contains 3 as its
    // only prime factor.
    // If n contains any other prime factor (2, 5, 7, etc.), the modulus will not be
    // zero.

    public boolean isPowerOfThree_Optimal(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
