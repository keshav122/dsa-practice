package com.leetcode_practice.contest.weekly.count_462;

public class IsTrionic {
    public static boolean isTrionic(int[] nums) {
        int n = nums.length;
        boolean firstLocalMaximaFound = false;
        boolean firstLocalMinimaFound = false;
        int i = 1;
        while (i < n - 1) {
            if (!firstLocalMaximaFound) {
                if (nums[i] <= nums[i - 1]) {
                    return false;
                } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    firstLocalMaximaFound = true;
                }
            } else if (!firstLocalMinimaFound) {
                if (nums[i] >= nums[i - 1]) {
                    return false;
                } else if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                    firstLocalMinimaFound = true;
                }
            } else {
                if (nums[i] <= nums[i - 1] || nums[i] >= nums[i + 1]) {
                    return false;
                }
            }
            i++;
        }
        return firstLocalMaximaFound && firstLocalMinimaFound;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 2, 1, 4, 7, 3 };
        System.out.println(isTrionic(nums));
    }
}
