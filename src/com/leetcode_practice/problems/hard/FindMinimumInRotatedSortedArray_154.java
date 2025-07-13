package com.leetcode_practice.problems.hard;

public class FindMinimumInRotatedSortedArray_154 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                ans = Math.min(ans, nums[mid]);
                low = low + 1;
                high = high - 1;
            } else if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else if (nums[mid] <= nums[high]) {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
