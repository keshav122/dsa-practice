package com.leetcode_practice.problems.easy;

public class FindNumbersWithEvenNumberOfDigits_1295 {

    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (numberOfDigits(num) % 2 == 0)
                ans++;
        }
        return ans;
    }

    private int numberOfDigits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }
}
