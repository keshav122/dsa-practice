package com.leetcode_practice.problems.medium;

public class MinimumPenaltyForAShop_2483 {
    public int bestClosingTime(String customers) {
        int maxVal = 0;
        int maxIndex = 0;
        int curr = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                curr++;
                if (curr > maxVal) {
                    maxVal = curr;
                    maxIndex = i + 1;
                }
            } else {
                curr--;
            }
        }
        return maxIndex;
    }
}
