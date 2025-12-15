package com.leetcode_practice.contest.weekly.count_480;

import java.util.Arrays;

public class AbsoluteDiffBetweenMinAndMaxKElements_3774 {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int kSmallSum = 0, kLargeSum = 0, i = 0, j = n - 1;
        for (int cnt = 1; cnt <= k; cnt++) {
            kSmallSum += nums[i];
            kLargeSum += nums[j];
            i++;
            j--;
        }
        return kLargeSum - kSmallSum;
    }
}
