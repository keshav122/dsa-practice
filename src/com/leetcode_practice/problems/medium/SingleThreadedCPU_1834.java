package com.leetcode_practice.problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU_1834 {

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] t = new Task[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Task(tasks[i][0], tasks[i][1], i);
        }
        Arrays.sort(t, Comparator.<Task>comparingInt(a -> a.enqueue));
        // Min-heap sorted by (processingTime, index)
        PriorityQueue<Task> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.process != b.process)
                        return a.process - b.process;
                    return a.index - b.index;
                });

        int[] res = new int[n];
        int resIdx = 0;
        long time = 0;
        int i = 0; // pointer in sorted tasks

        while (resIdx < n) {

            // Load all tasks whose enqueue time <= current time
            while (i < n && t[i].enqueue <= time) {
                pq.add(t[i]);
                i++;
            }

            if (!pq.isEmpty()) {
                // Choose task with smallest processing time, then index
                Task task = pq.poll();
                res[resIdx++] = task.index;
                time += task.process;
            } else {
                // CPU idle → jump to next enqueue time
                time = t[i].enqueue;
            }
        }

        return res;
    }
}

class Task {
    int enqueue;
    int process;
    int index;

    public Task(int enqueue, int process, int index) {
        this.enqueue = enqueue;
        this.process = process;
        this.index = index;
    }
}
