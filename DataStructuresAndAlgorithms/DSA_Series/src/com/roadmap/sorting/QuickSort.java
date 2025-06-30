package com.roadmap.sorting;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high)
            return;
        int pivotIndex = findPivotIndex(nums, low, high);
        quickSort(nums, low, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, high);
    }

    private int findPivotIndex(int[] nums, int low, int high) {
        int pivotElement = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (nums[i] <= pivotElement && i < high) {
                i++;
            }
            while (nums[j] > pivotElement && j > low) {
                j--;
            }
            // swap i and j
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

        }

        // swap low and j
        nums[low] = nums[j];
        nums[j] = pivotElement;
        return j;
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
