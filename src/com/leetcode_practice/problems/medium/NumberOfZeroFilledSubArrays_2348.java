package com.leetcode_practice.problems.medium;

public class NumberOfZeroFilledSubArrays_2348 {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long totalCount = 0;
        for (int i = 0; i < n; i++) {
            long count = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            totalCount += count;
        }
        return totalCount;
    }

    // For k continuous zeroes , the subarray count will be (k * (k+1))/2
    public long zeroFilledSubarray_optimal(int[] nums) {
        long count = 0;
        int n = nums.length;
        int zeroStreak = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroStreak++;
                count += zeroStreak;
            } else {
                zeroStreak = 0;
            }
        }
        return count;
    }
}
