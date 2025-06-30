package com.dsa_series.roadmap.binary_search.logic_building;

public class FirstAndlastOccurenceInArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int n = nums.length;
        ans[0] = firstOccurence(nums, n, target);
        ans[1] = lastOccurence(nums, n, target);
        return ans;
    }

    private int firstOccurence(int[] nums, int n, int target) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    private int lastOccurence(int[] nums, int n, int target) {
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

}
