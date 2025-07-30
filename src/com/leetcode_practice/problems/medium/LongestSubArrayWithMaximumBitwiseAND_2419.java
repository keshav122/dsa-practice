package com.leetcode_practice.problems.medium;

public class LongestSubArrayWithMaximumBitwiseAND_2419 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int count = 1;
        int maxCount = 1;
        int j = maxIndex + 1;
        while (j < n) {
            if (nums[j] == max) {
                count++;
                maxCount = maxCount > count ? maxCount : count;
            } else {
                count = 0;
            }
            j++;
        }
        return maxCount;
    }
}
