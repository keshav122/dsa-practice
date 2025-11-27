package com.leetcode_practice.contest.biweekly.count_170;

public class MinimumFlipsToReverseBinaryString_3750 {
    public int minimumFlips(int n) {
        String binary = Integer.toBinaryString(n);
        int i = 0, j = binary.length() - 1;
        int count = 0;
        while (i < j) {
            if (binary.charAt(i) != binary.charAt(j)) {
                count += 2;
            }
            i++;
            j--;
        }
        return count;
    }
}
