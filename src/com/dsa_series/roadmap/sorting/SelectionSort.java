package com.dsa_series.roadmap.sorting;

/*
 * The idea of Selection sort is that in one iteration you bring the smallest element to 
 * the start of the array.And then you repeat until you have all the values sorted.
 */
public class SelectionSort {
    public int[] selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minValue = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < minValue) {
                    minValue = nums[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = minValue;
                nums[minIndex] = temp;
            }
        }
        return nums;
    }
}
