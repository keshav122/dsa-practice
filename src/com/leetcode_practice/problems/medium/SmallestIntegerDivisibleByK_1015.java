package com.leetcode_practice.problems.medium;

public class SmallestIntegerDivisibleByK_1015 {

    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0)
            return -1;
        int val = 1;
        for (int i = 0; i <= k; i++) {
            if (val % k == 0)
                return (i + 1);
            val = ((val * 10) % k + 1) % k;
        }
        return -1;
    }
}
