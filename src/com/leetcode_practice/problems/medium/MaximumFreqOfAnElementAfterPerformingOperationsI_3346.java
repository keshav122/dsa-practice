package com.leetcode_practice.problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumFreqOfAnElementAfterPerformingOperationsI_3346 {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 1;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        int maxVal = nums[n - 1];
        for (int target = 1; target <= maxVal; target++) {
            ans = Math.max(ans, maximumFreq(target, nums, freqMap, k, numOperations));
        }
        return ans;
    }

    private int maximumFreq(int target, int[] nums, Map<Integer, Integer> freqMap, int k, int numOperations) {
        int left = getIndex(nums, target - k);
        int right = getIndex(nums, target + k + 1);
        int op = right - left - freqMap.getOrDefault(target, 0);
        return Math.min(numOperations, op) + freqMap.getOrDefault(target, 0);
    }

    private int getIndex(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
