package com.leetcode_practice.problems.medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlppingIntervals_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        // Sorting based on end times and then on start times
        // Meetings ending first must be taken first
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));
        int lastEndTime = intervals[0][1];
        int n = intervals.length;
        int count = 1;// count of non-overlapping interval
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastEndTime) {
                count++;
                lastEndTime = intervals[i][1];
            }
        }
        return n - count;
    }

    public static int comp(int[] val1, int[] val2) {
        return Integer.compare(val1[1], val2[1]);
    }

    public int eraseOverlapIntervals_alternate(int[][] intervals) {
        Arrays.sort(intervals, NonOverlppingIntervals_435::comp);
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); Lambda
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[1])); // Comparator API
        int lastEndTime = intervals[0][1];
        int n = intervals.length;
        int count = 1;// count of non-overlapping interval
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= lastEndTime) {
                count++;
                lastEndTime = intervals[i][1];
            }
        }
        return n - count;
    }
}
