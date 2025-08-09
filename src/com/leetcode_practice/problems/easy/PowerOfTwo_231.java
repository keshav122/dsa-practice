package com.leetcode_practice.problems.easy;

public class PowerOfTwo_231 {

    public boolean isPowerOfTwo_BF(int n) {
        if (n < 0)
            return false;
        int[] hash = new int[32];
        for (int i = 0; i < 32; i++) {
            hash[i] = i;
        }
        for (int a : hash) {
            if (Math.pow(2, a) == n)
                return true;
        }
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 1)
            return true;
        if (n <= 0 || n % 2 != 0)
            return false;
        return isPowerOfTwo(n / 2);
    }

    public boolean isPowerOfTwo_Bit(int n) {
        if (n <= 0)
            return false;
        return (n & (n - 1)) == 0;
    }
}
