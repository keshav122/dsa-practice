package com.leetcode_practice.problems.easy;

public class SumOfDigitsInBaseK_1837 {
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += (n % k);
            n /= k;
        }
        return sum;
    }
}
