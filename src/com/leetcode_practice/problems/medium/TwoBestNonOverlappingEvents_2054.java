package com.leetcode_practice.problems.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TwoBestNonOverlappingEvents_2054 {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        // Min-heap ordered by end time
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]);

        int bestPast = 0; // max value of events that ended before current
        int ans = 0;

        for (int[] e : events) {
            int start = e[0], value = e[2];

            // Remove all events that end before this event starts
            // (end < start because end is inclusive)
            while (!pq.isEmpty() && pq.peek()[1] < start) {
                bestPast = Math.max(bestPast, pq.poll()[2]);
            }

            // Combine current event with best compatible past event
            ans = Math.max(ans, bestPast + value);

            // Push current event into heap
            pq.offer(e);
        }

        return ans;
    }
}