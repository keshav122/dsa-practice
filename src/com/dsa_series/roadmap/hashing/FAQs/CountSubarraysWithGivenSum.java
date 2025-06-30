package com.dsa_series.roadmap.hashing.FAQs;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithGivenSum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumFreqMap = new HashMap<>();
        int count = 0;
        int sum = 0;
        sumFreqMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumFreqMap.containsKey(sum - k)) {
                count += sumFreqMap.get(sum - k);
            }
            sumFreqMap.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}
