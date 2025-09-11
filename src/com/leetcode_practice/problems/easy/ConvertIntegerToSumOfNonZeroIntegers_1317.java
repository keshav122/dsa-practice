package com.leetcode_practice.problems.easy;

public class ConvertIntegerToSumOfNonZeroIntegers_1317 {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            int a = i;
            int b = n - i;
            if (nonZero(a) && nonZero(b))
                return new int[] { a, b };
        }
        return new int[] { -1, -1 };
    }

    private boolean nonZero(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0)
                return false;
            n /= 10;
        }
        return true;
    }
}
