package com.leetcode_practice.contest.weekly.count_491;

public class MinimumCostToSplitIntoOnes_3857 {
    public int minCost(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;

        if (n % 2 == 0) {
            int half = (n / 2);
            return (half * half) + minCost(half) + minCost(half);
        } else {
            int half = (n / 2);
            int oddHalf = (n / 2) + 1;
            return (half * oddHalf) + minCost(half) + minCost(oddHalf);
        }

    }
}
