package com.dsa_series.roadmap.binary_search.contests;

import java.util.Arrays;

public class NeighborsWithinKDistance {
    public int[] neighboursWithKDistance(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int lowerVal = Math.max(nums[i] - k, temp[0]);
            int upperVal = Math.min(nums[i] + k, temp[n - 1]);
            int lIndex = getLowerIndex(temp, lowerVal, n);
            int uIndex = getUpperIndex(temp, upperVal, n);
            ans[i] = uIndex - lIndex + 1;
        }
        return ans;
    }

    private int getLowerIndex(int[] temp, int lowerVal, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (temp[mid] >= lowerVal) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int getUpperIndex(int[] temp, int upperVal, int n) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (temp[mid] <= upperVal) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
