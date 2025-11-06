package com.leetcode_practice.problems.hard;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    // for larger half
    PriorityQueue<Integer> left;
    // for smaller half
    PriorityQueue<Integer> right;

    public MedianFinder() {
        right = new PriorityQueue<>();// minheap
        left = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
    }

    public void addNum(int num) {

        if ((left.size() + right.size()) == 0 || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }
        rebalance(left, right);
    }

    private void rebalance(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        while (Math.abs(left.size() - right.size()) > 1) {
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            }

            if (right.size() > left.size() + 1) {
                left.add(right.poll());
            }
        }
    }

    public double findMedian() {
        if (left.size() > right.size()) {
            return left.peek();
        } else if (right.size() > left.size()) {
            return right.peek();
        } else {
            return (left.peek() + right.peek()) / 2.0;
        }
    }
}

public class FindMedianFromDataStream_295 {
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
}
