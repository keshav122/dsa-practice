package com.leetcode_practice.contest.weekly.count_462;

import java.util.PriorityQueue;

public class MaximumTimeToActivateString {

    public int minTime(String s, int[] order, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < order.length; i++) {
            pq.add(new Pair(order[i], i));
        }
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int time = p.order;
            int index = p.index;
            String tempString = s.substring(0, index) + "*" + s.substring(index + 1);
            s = tempString;
            if (validSubstringsCount(tempString, k)) {
                return time;
            }
        }
        return -1;
    }

    // TODO - Could not complete it
    private boolean validSubstringsCount(String tempString, int k) {
        return false;
    }
}

class Pair {
    int order;
    int index;

    Pair(int order, int index) {
        this.order = order;
        this.index = index;
    }
}
