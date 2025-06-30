package com.dsa_series.roadmap.sorting;

public class MergeSort {
    public int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;
        int midIndex = (startIndex + endIndex) / 2;
        mergeSort(nums, startIndex, midIndex);
        mergeSort(nums, midIndex + 1, endIndex);
        mergeSortedArrays(nums, startIndex, midIndex, endIndex);
    }

    private void mergeSortedArrays(int[] nums, int startIndex, int midIndex, int endIndex) {
        int[] tempArr = new int[endIndex - startIndex + 1];
        int left = startIndex;
        int right = midIndex + 1;
        int k = 0;
        while (left <= midIndex && right <= endIndex) {
            if (nums[left] > nums[right]) {
                tempArr[k] = nums[right];
                right++;
            } else {
                tempArr[k] = nums[left];
                left++;
            }
            k++;
        }

        while (left <= midIndex) {
            tempArr[k] = nums[left];
            left++;
            k++;
        }

        while (right <= endIndex) {
            tempArr[k] = nums[right];
            right++;
            k++;
        }

        // Copy tempArray back to original
        for (int i = startIndex; i <= endIndex; i++) {
            nums[i] = tempArr[i - startIndex];
        }
    }
}
