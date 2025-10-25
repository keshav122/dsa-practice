package com.leetcode_practice.problems.easy;

public class CalculateMoneyInLeetCodeBank_1716 {
    public int totalMoney(int n) {
        int currVal = 1;
        int totalVal = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 7 == 1) {
                currVal = (i / 7) + 1;
                totalVal += currVal;
            } else {
                totalVal += currVal;
            }
            currVal++;
        }
        return totalVal;
    }
}
