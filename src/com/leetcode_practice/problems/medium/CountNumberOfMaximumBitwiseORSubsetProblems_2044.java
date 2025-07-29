package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfMaximumBitwiseORSubsetProblems_2044 {
    public int countMaxOrSubsets(int[] nums) {
        Map<Integer, Integer> bitwiseORSumFreqMap = new HashMap<>();
        subsets(0, 0, nums, bitwiseORSumFreqMap);
        int maxSum = 0;
        for (int key : bitwiseORSumFreqMap.keySet()) {
            maxSum = maxSum > key ? maxSum : key;
        }
        return bitwiseORSumFreqMap.get(maxSum);
    }

    private void subsets(int index, int currVal, int[] nums, Map<Integer, Integer> bitwiseORSumFreqMap) {
        if (index == nums.length) {
            bitwiseORSumFreqMap.merge(currVal, 1, Integer::sum);
            return;
        }
        subsets(index + 1, currVal | nums[index], nums, bitwiseORSumFreqMap);
        subsets(index + 1, currVal, nums, bitwiseORSumFreqMap);

    }
}
