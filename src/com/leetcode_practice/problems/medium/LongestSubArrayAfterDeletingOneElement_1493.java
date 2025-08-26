package com.leetcode_practice.problems.medium;

public class LongestSubArrayAfterDeletingOneElement_1493 {

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0, zeroCount = 0, maxSize = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[l] == 0) {
                    zeroCount--;
                }
                l++;
            }

            // window length = (r - l + 1)
            // but since we must delete 1 element, effective length = (r - l)
            maxSize = Math.max(maxSize, r - l);
        }
        return maxSize;
    }
}