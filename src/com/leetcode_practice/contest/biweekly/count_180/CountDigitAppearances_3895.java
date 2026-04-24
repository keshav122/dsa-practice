package com.leetcode_practice.contest.biweekly.count_180;

public class CountDigitAppearances_3895 {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;
        for (int num : nums) {
            count += digitCount(num, digit);
        }
        return count;
    }

    private int digitCount(int n, int x) {
        int count = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit == x)
                count++;
            n /= 10;
        }
        return count;
    }
}
