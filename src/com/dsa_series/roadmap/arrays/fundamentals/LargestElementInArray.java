package com.dsa_series.roadmap.arrays.fundamentals;

public class LargestElementInArray {
    public int largestElement(int[] nums) {
        int largestElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            largestElement = Math.max(largestElement, nums[i]);
        }
        return largestElement;
    }
}
