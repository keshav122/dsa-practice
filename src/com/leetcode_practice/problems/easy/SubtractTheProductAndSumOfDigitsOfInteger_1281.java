package com.leetcode_practice.problems.easy;

public class SubtractTheProductAndSumOfDigitsOfInteger_1281 {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        return product - sum;
    }
}
