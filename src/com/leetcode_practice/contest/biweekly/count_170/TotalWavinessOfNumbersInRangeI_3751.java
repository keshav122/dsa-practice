package com.leetcode_practice.contest.biweekly.count_170;

public class TotalWavinessOfNumbersInRangeI_3751 {
    // 1 <= num1 <= num2 <= 100000
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int i = num1; i <= num2; i++) {
            if (i <= 100) {
                continue;
            } else {
                total += getWaviness(i);
            }
        }
        return total;
    }

    private int getWaviness(int n) {
        String s = Integer.toString(n);
        int count = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i - 1) && s.charAt(i) > s.charAt(i + 1)) {
                count++;
            } else if (s.charAt(i) < s.charAt(i - 1) && s.charAt(i) < s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
