package com.roadmap.binary_search.fundamentals;

public class UpperBound {
    public int upperBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
}
