package com.leetcode_practice.problems.medium;

public class PartitioningIntoDeciNumbers_1689 {
    public int minPartitions(String s) {
        int max = -1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            max = Math.max(max, s.charAt(i) - '0');
        }
        return max;
    }
}
