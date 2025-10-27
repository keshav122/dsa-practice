/*Author: keshav122 */
package com.dsa_series.roadmap.greedy_algorithms.scheduling_and_interval_problems;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int MaximumNonOverlappingIntervals(int[][] Intervals) {
        Arrays.sort(Intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int n = Intervals.length;
        int releaseTime = Intervals[0][1];
        int removedIntervals = 0;
        for (int i = 1; i < n; i++) {
            if (Intervals[i][0] < releaseTime) {
                removedIntervals++;
            } else {
                releaseTime = Intervals[i][1];
            }
        }
        return removedIntervals;
    }
}