package com.dsa_series.roadmap.heaps.theory_and_implementation;

public class HeapifyAlgorithm {
    public void heapify(int[] nums, int ind, int val) {
        if (nums[ind] < val) {
            nums[ind] = val;
            heapifyDown(nums, ind);
        } else {
            nums[ind] = val;
            heapifyUp(nums, ind);
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

    void heapifyUp(int[] nums, int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && nums[index] < nums[parent]) {
            swap(nums, parent, index);
            heapifyUp(nums, parent);
        }
    }

    void swap(int[] nums, int smallest, int index) {
        int temp = nums[index];
        nums[index] = nums[smallest];
        nums[smallest] = temp;
    }
}
