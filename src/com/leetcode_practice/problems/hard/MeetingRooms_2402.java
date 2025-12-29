package com.leetcode_practice.problems.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms_2402 {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[0]));
        int[] count = new int[n];
        PriorityQueue<Integer> available = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> a[0] == b[0]
                ? Long.compare(a[1], b[1])
                : Long.compare(a[0], b[0]));
        for (int i = 0; i < n; i++)
            available.add(i);

        for (int[] m : meetings) {
            long start = m[0], end = m[1];
            long duration = end - start;

            // Free rooms that have completed by meeting start
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.add((int) busy.poll()[1]);
            }

            if (!available.isEmpty()) {
                int room = available.poll();
                count[room]++;
                busy.add(new long[] { end, room });
            } else {
                // Delay the meeting
                long[] earliest = busy.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                count[room]++;
                busy.add(new long[] { newEnd, room });
            }
        }

        int best = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[best])
                best = i;
        }
        return best;
    }
}
