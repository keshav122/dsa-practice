package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class MaximiseHappinessOfChildren_3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long sum = 0;
        int count = 0;
        for (int i = n - 1; i >= Math.max(n - k, 0); i--) {
            int val = happiness[i] - count;
            if (val > 0) {
                sum += (happiness[i] - count);
            }
            count++;
        }
        return sum;
    }
}