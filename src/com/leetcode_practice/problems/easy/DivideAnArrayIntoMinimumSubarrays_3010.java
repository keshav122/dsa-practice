package com.leetcode_practice.problems.easy;

import java.util.Arrays;

public class DivideAnArrayIntoMinimumSubarrays_3010 {
    public int minimumCost(int[] nums) {
        Arrays.sort(nums, 1, nums.length);
        return nums[0] + nums[1] + nums[2];
    }

    public int minimumCost_optimal(int[] nums) {
        int first = nums[0];
        int minSoFar = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (minSoFar != Integer.MAX_VALUE) {
                ans = Math.min(ans, first + minSoFar + nums[i]);
            }
            minSoFar = Math.min(minSoFar, nums[i]);
        }
        return ans;
    }
}
