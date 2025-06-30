package com.dsa_series.roadmap.arrays.fundamentals;

public class LeftArrayByKPlaces {
    public void rotateArray_BF(int[] nums, int k) {
        int n = nums.length;
        // If k is more than n , one full cycle of n will have no net effect on the
        // array.
        k = k % n;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }

        for (int j = k; j < n; j++) {
            nums[j - k] = nums[j];
        }
        for (int j = n - k, l = 0; j < n && l < k; j++, l++) {
            nums[j] = temp[l];
        }
    }

    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // reverse the whole array
        reverseArray(nums, 0, n - 1);
        // reverse the starting n-k elements
        reverseArray(nums, 0, n - k - 1);
        // reverse the last k elements
        reverseArray(nums, n - k, n - 1);
    }

    private void reverseArray(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
