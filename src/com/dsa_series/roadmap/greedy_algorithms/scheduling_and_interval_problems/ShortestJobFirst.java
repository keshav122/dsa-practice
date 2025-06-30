package com.dsa_series.roadmap.greedy_algorithms.scheduling_and_interval_problems;

import java.util.Arrays;

public class ShortestJobFirst {
    public long solve(int[] bt) {
        Arrays.sort(bt);
        int n = bt.length;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            bt[i] += bt[i - 1];
            ans += bt[i - 1];
        }
        return ans / n;
    }
}
