package com.dsa_series.roadmap.heaps.theory_and_implementation;

public class KthLargestElementInAnArray {

    public int kthLargestElement(int[] nums, int k) {
        int n = nums.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(nums, n - 1, i);
        }
        int last = nums.length - 1;
        while (last > 0) {
            swap(nums, 0, last);
            last--;
            if (k == n && last == 0) {
                return nums[0];
            }
            if (last == n - k - 1) {
                return nums[last + 1];
            }
            if (last > 0) {
                heapifyDown(nums, last, 0);
            }
        }
        return nums[n - k];
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
            swap(nums, index, largest);
            heapifyDown(nums, last, largest);
        }
    }
}

// Using pivot index based approach
class KthLargestElementInAnArrayOptimal {
    public int kthLargestElement(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (true) {
            int pivot = getRandomIndex(r, l);
            int pivotIndex = partitionAndReturnIndex(nums, pivot, l, r);
            if (pivotIndex == k - 1)
                return nums[pivotIndex];
            else if (k - 1 < pivotIndex)
                r = pivotIndex - 1;
            else
                l = pivotIndex + 1;
        }
    }

    public int partitionAndReturnIndex(int[] nums, int pivot, int l, int r) {
        // swap l & pivot -- moving pivot to the leftmost
        swap(nums, l, pivot);
        int index = l + 1;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > nums[l]) {
                // swap index , i
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, l, index - 1);
        return index - 1;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public int getRandomIndex(int l, int r) {
        return ((int) (Math.random() % (r - l + 1)) + l);
    }
}