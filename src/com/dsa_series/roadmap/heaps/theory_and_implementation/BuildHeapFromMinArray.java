package com.dsa_series.roadmap.heaps.theory_and_implementation;

public class BuildHeapFromMinArray {
    public void buildMinHeap(int[] nums) {
        int n = nums.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(nums, i);
        }
    }

    void heapifyDown(int[] nums, int index) {
        int smallest = index, lChild = 2 * index + 1, rChild = 2 * index + 2, n = nums.length;
        if (lChild < n && nums[lChild] < nums[smallest]) {
            smallest = lChild;
        }
        if (rChild < n && nums[rChild] < nums[smallest]) {
            smallest = rChild;
        }
        if (smallest != index) {
            swap(nums, smallest, index);
            heapifyDown(nums, smallest);
        }

    }

    void swap(int[] nums, int smallest, int index) {
        int temp = nums[index];
        nums[index] = nums[smallest];
        nums[smallest] = temp;
    }
}
