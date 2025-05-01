package com.roadmap.binary_search.logic_building;

public class FloorAndCeilInSortedArray {
    public int[] getFloorAndCeil(int[] nums, int x) {
        int[] ans = new int[2];
        int n = nums.length;
        ans[0] = floor(nums, n, x);
        ans[1] = ceil(nums, n, x);
        return ans;
    }

    private int floor(int[] nums, int n, int x) {
        int ans = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= x) {
                ans = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int ceil(int[] nums, int n, int x) {
        int ans = -1;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= x) {
                ans = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

}
