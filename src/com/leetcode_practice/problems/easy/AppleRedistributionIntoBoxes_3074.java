package com.leetcode_practice.problems.easy;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes_3074 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalCapReq = 0;
        for (int size : apple) {
            totalCapReq += size;
        }
        Arrays.sort(capacity);
        int totalCap = 0;
        int m = capacity.length;
        for (int i = m - 1; i >= 0; i--) {
            totalCap += capacity[i];
            if (totalCap >= totalCapReq) {
                return m - i;
            }
        }
        return m;
    }
}
