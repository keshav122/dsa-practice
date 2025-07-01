package com.leetcode_practice.problems.easy;

import java.util.*;

public class Longest_Harmonious_Sequence_594 {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int lhs = 0;
        for (int i = 0; i < n - 1; i++) {
            int maxVal = nums[i];
            int minVal = nums[i];
            for (int j = i + 1; j < n; j++) {
                maxVal = Math.max(maxVal, nums[j]);
                minVal = Math.min(minVal, nums[j]);
                if (maxVal - minVal == 1) {
                    lhs = Math.max(lhs, j - i + 1);
                }
            }
        }
        return lhs;
    }

    public int findLHS_better(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i <= j) {
            int val = nums[j] - nums[i];
            if (val == 1) {
                return (j - i + 1);
            } else if (val > 1) {
                j--;
            } else {
                break;
            }
        }
        return -1;
    }

    // Hashmap based approach
    public int findLHS_optimal(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

        int maxLen = 0;
        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, freqMap.get(key) + freqMap.get(key + 1));
            }
        }
        return maxLen;
    }

}
