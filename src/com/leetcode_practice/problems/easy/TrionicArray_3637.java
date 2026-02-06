package com.leetcode_practice.problems.easy;

public class TrionicArray_3637 {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4)
            return false;

        int i = 1;
        // Phase 1 - Strictly increasing
        while (i < n && nums[i] > nums[i - 1])
            i++;
        if (i == 1 || i == n)
            return false;

        // Phase 2 - Strictly decreasing
        while (i < n && nums[i] < nums[i - 1])
            i++;
        if (i == n)
            return false;

        // Phase 3 - Strictly increasing
        while (i < n && nums[i] > nums[i - 1])
            i++;
        return i == n;
    }
}
