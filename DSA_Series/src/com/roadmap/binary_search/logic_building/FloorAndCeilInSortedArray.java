package com.roadmap.binary_search.logic_building;

public class FloorAndCeilInSortedArray {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int n = nums.length;
        int[] ans = new int[2];
        int lb = lowerBound(nums, x);
        if (lb < n && nums[lb] == x) {
            ans[0] = ans[1] = x;
            return ans;
        } else {
            ans[0] = (nums[lb - 1] > x) ? -1 : nums[lb - 1];
        }

        int ub = upperBound(nums, x);
        ans[1] = (ub > n - 1) ? -1 : nums[ub];
        return ans;
    }

    private int lowerBound(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
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

    private int upperBound(int[] nums, int x) {
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
