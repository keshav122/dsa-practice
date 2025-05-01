package com.roadmap.binary_search.fundamentals;

public class LowerBound {
    public int lowerBound(int[] nums, int x) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
