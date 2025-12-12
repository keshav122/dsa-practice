package com.leetcode_practice.problems.easy;

public class CountOddNumbersInAnIntervalRange_1428 {

    public int countOdds_BF(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 == 1)
                count++;
        }
        return count;
    }

    public int countOdds_better(int low, int high) {
        return (high - low) / 2 + ((low % 2 == 1 || high % 2 == 1) ? 1 : 0);
    }

    // F(x) = number of odd integers from 1 to x
    // odds(low..high) = F(high) − F(low−1)
    // F(x) = (x + 1) / 2 -- Take examples of x as odd and even to understand
    public int countOdds_optimal(int low, int high) {
        return (high + 1) / 2 - (low / 2);
    }
}
