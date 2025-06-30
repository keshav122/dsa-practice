package com.dsa_series.roadmap.arrays.logic_building;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        // We create a frequency map for each of the elements
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        // Iterate through the map and return the element with frequency 1
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int singleNumber_XOR(int[] nums) {
        // Because A^A = 0 doing XOR of the full array should give us the unique number
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
