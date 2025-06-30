package com.dsa_series.roadmap.binary_search.fundamentals;

/*Author: keshav122 */

public class SearchXInSortedArray {
    public int binarysearch(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    // Recursive Solution
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start > end)
            return -1;
        int mid = start + ((end - start) / 2);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search(nums, start, mid - 1, target);
        } else {
            return search(nums, mid + 1, end, target);
        }
    }
}