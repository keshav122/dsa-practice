package com.leetcode_practice.problems.easy;

public class AntOnTheBoundary_3028 {
    public int returnToBoundaryCount(int[] nums) {
        int pos = 0;
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pos += nums[i];
            if (pos == 0)
                count++;
        }
        return count;
    }
}
