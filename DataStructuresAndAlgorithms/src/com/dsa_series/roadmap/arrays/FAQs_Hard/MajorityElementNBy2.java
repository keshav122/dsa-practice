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
        int candidate = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate)
                count++;
        }
        return (count > (n / 2)) ? candidate : -1;
    }

}
