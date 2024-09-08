package com.roadmap.arrays.FAQs_Hard;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementNBy2 {
    public int majorityElement_BF(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > (nums.length / 2)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = nums[0];
        int occurenceCount = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == candidate) {
                occurenceCount++;
            } else {
                occurenceCount--;
                if (occurenceCount == 0) {
                    candidate = nums[i];
                    occurenceCount = 1;
                }
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return (count > n / 2) ? candidate : -1;

    }

}
