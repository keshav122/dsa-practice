package com.leetcode_practice.problems.hard;

public class NonNegativeIntegersWithoutConsecutiveOnes_600 {

    public int findIntegers(int n) {
        int count = 1; // 0 doesnt have consecutive ones
        for (int i = 1; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            boolean isConsecutiveOne = false;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == '1' && s.charAt(j - 1) == '1') {
                    isConsecutiveOne = true;
                    break;
                }
            }
            if (!isConsecutiveOne)
                count++;
        }
        return count;
    }
}
