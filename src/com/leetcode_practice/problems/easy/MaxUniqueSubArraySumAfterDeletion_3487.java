package com.leetcode_practice.problems.easy;

import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSubArraySumAfterDeletion_3487 {
    public int maxSum(int[] nums) {
        int maxSum = 0;
        int maxValue = Integer.MIN_VALUE;
        Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            if (num > 0 && !hash.contains(num)) {
                maxSum += num;
                hash.add(num);
            }
            maxValue = maxValue > num ? maxValue : num;
        }
        if (maxSum == 0)
            return maxValue;
        return maxSum;
    }
}
