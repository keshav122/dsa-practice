package com.dsa_series.roadmap.heaps.theory_and_implementation;

import java.util.*;

public class ImplementMinHeap {
    List<Integer> minHeap;

    public void initializeHeap() {
        minHeap = new ArrayList<>();
    }

    public void insert(int key) {
        minHeap.add(key);
        int n = minHeap.size();
        heapifyUp(minHeap, n - 1);
    }

    public void changeKey(int index, int newVal) {
        if (minHeap.get(index) < newVal) {
            minHeap.set(index, newVal);
            heapifyDown(minHeap, index);
        } else {
            minHeap.set(index, newVal);
            heapifyUp(minHeap, index);
        }
    }

    public void extractMin() {
        int n = minHeap.size();
        minHeap.set(0, minHeap.get(n - 1));
        minHeap.remove(n - 1);
        heapifyDown(minHeap, 0);
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

    public int getMin() {
        return minHeap.get(0);
    }

    public int heapSize() {
        return minHeap.size();
    }

    void heapifyDown(List<Integer> minHeap, int index) {
        int smallest = index;
        int n = minHeap.size();
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;
        if (lChild < n && minHeap.get(lChild) < minHeap.get(smallest)) {
            smallest = lChild;
        }
        if (rChild < n && minHeap.get(rChild) < minHeap.get(smallest)) {
            smallest = rChild;
        }

        if (smallest != index) {
            int temp = minHeap.get(index);
            minHeap.set(index, minHeap.get(smallest));
            minHeap.set(smallest, temp);
            heapifyDown(minHeap, smallest);
        }
    }

    void heapifyUp(List<Integer> minHeap, int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && minHeap.get(parent) > minHeap.get(index)) {
            int temp = minHeap.get(parent);
            minHeap.set(parent, minHeap.get(index));
            minHeap.set(index, temp);
            heapifyUp(minHeap, parent);
        }
    }
}
