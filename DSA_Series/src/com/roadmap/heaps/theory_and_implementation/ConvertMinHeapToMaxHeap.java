/*Author: keshav122 */
package com.roadmap.heaps.theory_and_implementation;

public class ConvertMinHeapToMaxHeap {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(nums, i);
        }
        return nums;
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
