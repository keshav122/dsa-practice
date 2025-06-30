package com.roadmap.heaps.theory_and_implementation;

public class HeapSort {
    public void heapSort_BF(int[] nums) {
        // Build a max-heap from the given array
        int n = nums.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(nums, i);
        }
        int last = nums.length - 1;
        while (last > 0) {
            swap(nums, 0, last);
            last--;
            if (last > 0) {
                heapifyDown(nums, last, 0);
            }
        }
    }

    void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    void heapifyDown(int[] nums, int last, int index) {
        int largest = index;
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;
        if (lChild <= last && nums[lChild] > nums[largest]) {
            largest = lChild;
        }
        if (rChild <= last && nums[rChild] > nums[largest]) {
            largest = rChild;
        }

        if (largest != index) {
            int temp = nums[index];
            nums[index] = nums[largest];
            nums[largest] = temp;
            heapifyDown(nums, last, largest);
        }
    }

    void heapifyDown(int[] nums, int index) {
        int largest = index;
        int n = nums.length;
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;
        if (lChild < n && nums[lChild] > nums[largest]) {
            largest = lChild;
        }
        if (rChild < n && nums[rChild] > nums[largest]) {
            largest = rChild;
        }

        if (largest != index) {
            int temp = nums[index];
            nums[index] = nums[largest];
            nums[largest] = temp;
            heapifyDown(nums, largest);
        }
    }
}

class HeapSort_better {
    public void heapSort(int[] nums) {
        // Build a max-heap from the given array
        int n = nums.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(nums, n - 1, i);
        }
        int last = nums.length - 1;
        while (last > 0) {
            swap(nums, 0, last);
            last--;
            if (last > 0) {
                heapifyDown(nums, last, 0);
            }
        }
    }

    void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    void heapifyDown(int[] nums, int last, int index) {
        int largest = index;
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;
        if (lChild <= last && nums[lChild] > nums[largest]) {
            largest = lChild;
        }
        if (rChild <= last && nums[rChild] > nums[largest]) {
            largest = rChild;
        }

        if (largest != index) {
            int temp = nums[index];
            nums[index] = nums[largest];
            nums[largest] = temp;
            heapifyDown(nums, last, largest);
        }
    }
}
