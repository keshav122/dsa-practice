package com.roadmap.heaps.theory_and_implementation;

import java.util.ArrayList;
import java.util.List;

public class ImplementMaxHeap {
    List<Integer> maxHeap;

    public void initializeHeap() {
        maxHeap = new ArrayList<>();
    }

    public void insert(int key) {
        maxHeap.add(key);
        heapifyUp(maxHeap, maxHeap.size() - 1);
    }

    public void changeKey(int index, int newVal) {
        if (maxHeap.get(index) < newVal) {
            maxHeap.set(index, newVal);
            heapifyUp(maxHeap, index);
        } else {
            maxHeap.set(index, newVal);
            heapifyDown(maxHeap, index);
        }
    }

    public void extractMax() {
        maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
        maxHeap.remove(maxHeap.size() - 1);
        heapifyDown(maxHeap, 0);
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    public int getMax() {
        return maxHeap.get(0);
    }

    public int heapSize() {
        return maxHeap.size();
    }

    void heapifyDown(List<Integer> maxHeap, int index) {
        int largest = index;
        int n = maxHeap.size();
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;
        if (lChild < n && maxHeap.get(lChild) > maxHeap.get(largest)) {
            largest = lChild;
        }
        if (rChild < n && maxHeap.get(rChild) > maxHeap.get(largest)) {
            largest = rChild;
        }

        if (largest != index) {
            int temp = maxHeap.get(index);
            maxHeap.set(index, maxHeap.get(largest));
            maxHeap.set(largest, temp);
            heapifyDown(maxHeap, largest);
        }
    }

    void heapifyUp(List<Integer> maxHeap, int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && maxHeap.get(parent) < maxHeap.get(index)) {
            int temp = maxHeap.get(parent);
            maxHeap.set(parent, maxHeap.get(index));
            maxHeap.set(index, temp);
            heapifyUp(maxHeap, parent);
        }
    }
}

class MaxHeapUsingCount {

    List<Integer> maxHeap;
    private int count;

    public void initializeHeap() {
        maxHeap = new ArrayList<>();
        count = 0;
    }

    public void insert(int key) {
        maxHeap.add(key);
        count++;
        heapifyUp(maxHeap, count - 1);
    }

    public void changeKey(int index, int newVal) {
        if (maxHeap.get(index) < newVal) {
            maxHeap.set(index, newVal);
            heapifyUp(maxHeap, index);
        } else {
            maxHeap.set(index, newVal);
            heapifyDown(maxHeap, index);
        }
    }

    public void extractMax() {
        maxHeap.set(0, maxHeap.get(maxHeap.size() - 1));
        maxHeap.remove(count - 1);
        count--;
        heapifyDown(maxHeap, 0);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getMax() {
        return maxHeap.get(0);
    }

    public int heapSize() {
        return count;
    }

    void heapifyDown(List<Integer> maxHeap, int index) {
        int largest = index;
        int n = maxHeap.size();
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;
        if (lChild < n && maxHeap.get(lChild) > maxHeap.get(largest)) {
            largest = lChild;
        }
        if (rChild < n && maxHeap.get(rChild) > maxHeap.get(largest)) {
            largest = rChild;
        }

        if (largest != index) {
            int temp = maxHeap.get(index);
            maxHeap.set(index, maxHeap.get(largest));
            maxHeap.set(largest, temp);
            heapifyDown(maxHeap, largest);
        }
    }

    void heapifyUp(List<Integer> maxHeap, int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && maxHeap.get(parent) < maxHeap.get(index)) {
            int temp = maxHeap.get(parent);
            maxHeap.set(parent, maxHeap.get(index));
            maxHeap.set(index, temp);
            heapifyUp(maxHeap, parent);
        }
    }
}

class OfficialSolution {

    List<Integer> maxHeap;
    private int count;

    public void initializeHeap() {
        maxHeap = new ArrayList<>();
        count = 0;
    }

    public void insert(int key) {
        maxHeap.add(key);
        count++;
        heapifyUp(maxHeap, count - 1);
    }

    public void changeKey(int index, int newVal) {
        if (maxHeap.get(index) < newVal) {
            maxHeap.set(index, newVal);
            heapifyUp(maxHeap, index);
        } else {
            maxHeap.set(index, newVal);
            heapifyDown(maxHeap, index);
        }
    }

    public void extractMax() {
        maxHeap.set(0, maxHeap.get(count - 1));
        maxHeap.remove(count - 1);
        count--;
        heapifyDown(maxHeap, 0);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getMax() {
        return maxHeap.get(0);
    }

    public int heapSize() {
        return count;
    }

    void heapifyDown(List<Integer> maxHeap, int index) {
        int largest = index;
        int n = maxHeap.size();
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;
        if (lChild < n && maxHeap.get(lChild) > maxHeap.get(largest)) {
            largest = lChild;
        }
        if (rChild < n && maxHeap.get(rChild) > maxHeap.get(largest)) {
            largest = rChild;
        }

        if (largest != index) {
            int temp = maxHeap.get(index);
            maxHeap.set(index, maxHeap.get(largest));
            maxHeap.set(largest, temp);
            heapifyDown(maxHeap, largest);
        }
    }

    void heapifyUp(List<Integer> maxHeap, int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && maxHeap.get(parent) < maxHeap.get(index)) {
            int temp = maxHeap.get(parent);
            maxHeap.set(parent, maxHeap.get(index));
            maxHeap.set(index, temp);
            heapifyUp(maxHeap, parent);
        }
    }
}