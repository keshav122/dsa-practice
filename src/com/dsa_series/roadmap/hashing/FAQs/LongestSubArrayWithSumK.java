package com.dsa_series.roadmap.hashing.FAQs;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int sum = 0;
        int max_len = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                max_len = Math.max(max_len, i + 1);
            } else if (sumIndexMap.containsKey(sum - k)) {
                max_len = Math.max(max_len, i - sumIndexMap.get(sum - k));
            }
            sumIndexMap.put(sum, i);
        }
        return max_len;
    }
}
