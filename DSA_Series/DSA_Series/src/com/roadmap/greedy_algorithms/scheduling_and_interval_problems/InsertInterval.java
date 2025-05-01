package com.roadmap.greedy_algorithms.scheduling_and_interval_problems;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> resultantList = new ArrayList<>();
        int i = 0;

        // Adding the left part
        while (i < n && intervals[i][1] < newInterval[0]) {
            resultantList.add(intervals[i]);
            i++;
        }

        // Merging the overlapping interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        resultantList.add(newInterval);

        // Adding the right part
        while (i < n) {
            resultantList.add(intervals[i]);
            i++;
        }

        return resultantList.toArray(new int[resultantList.size()][]);
    }
}
