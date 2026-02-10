package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestBalancedSubarrayI_3719 {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n - 1; i++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            if (nums[i] % 2 == 0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % 2 == 0)
                    even.add(nums[j]);
                else
                    odd.add(nums[j]);
                if (even.size() == odd.size()) {
                    maxLen = Math.max(j - i + 1, maxLen);
                }
            }
        }
        return maxLen;
    }
}
