package com.roadmap.binary_search.logic_building;

public class SearchInRotatedSortedArray1 {
    public int search(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == k)
                return mid;
            // Identify the sorted half
            // We first to need to identify which half is sorted so that we can apply
            // BS on it
            // left Half is sorted
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= k && nums[mid] > k) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] <= k && k <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
}
