package com.roadmap.sorting;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex)
            return;
        int pivotIndex = partition(nums, startIndex, endIndex);
        quickSort(nums, startIndex, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, endIndex);

    }

    private int partition(int[] nums, int startIndex, int endIndex) {
        int pivotElement = nums[startIndex];
        int count = 1;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (nums[i] <= pivotElement) {
                count++;
            }
        }
        int pivotPos = startIndex + count;
        // swap the startIndex and element at pivotPos
        int temp = nums[pivotPos];
        nums[pivotPos] = nums[startIndex];
        nums[startIndex] = temp;

        int i = startIndex;
        int j = endIndex;
        while (i < pivotPos && j > pivotPos) {
            if (nums[i] <= pivotElement) {
                i++;
            }
            if (nums[j] > pivotElement) {
                j--;
            }
            if (nums[i] > pivotElement && nums[j] <= pivotElement) {
                int tempVal = nums[i];
                nums[i] = nums[j];
                nums[j] = tempVal;
                i++;
                j--;
            }
        }
        return pivotPos;
    }

    public static void main(String[] args) {
        int[] ans = { 5, 4, 4, 1, 1 };
        QuickSort q = new QuickSort();
        int[] result = q.quickSort(ans);
        for (int a : result) {
            System.out.print(a + " ");
        }
    }
}
