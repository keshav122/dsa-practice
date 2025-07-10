package com.leetcode_practice.problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxNumberOfEventsThatCanBeAttended_1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 0, i = 0, n = events.length, attended = 0;

        while (!minHeap.isEmpty() || i < n) {
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }
            // For events starting today => put their endDay in minHeap
            while (i < n && events[i][0] <= day) {
                minHeap.add(events[i][1]);
                i++;
            }
            // Remove events from minHeap which have expired
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            // If heap is not empty
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
                day++;
            }
        }
        //
        return attended;
    }
}
