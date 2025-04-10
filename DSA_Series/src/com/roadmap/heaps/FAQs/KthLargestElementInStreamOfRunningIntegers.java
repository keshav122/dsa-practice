package com.roadmap.heaps.FAQs;

import java.util.PriorityQueue;

public class KthLargestElementInStreamOfRunningIntegers {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int K;

    public KthLargestElementInStreamOfRunningIntegers(int k, int[] nums) {
        K = k;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            } else if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (pq.size() < K) {
            pq.add(val);
        } else if (pq.size() >= K && val > pq.peek()) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
