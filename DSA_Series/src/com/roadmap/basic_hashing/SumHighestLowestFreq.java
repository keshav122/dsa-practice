package com.roadmap.basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class SumHighestLowestFreq {
    public int sumHighestAndLowestFrequency(int[] nums) {
        // This map stores the frequency of the elements in the array
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int element : nums) {
            freqMap.merge(element, 1, Integer::sum);
        }
        return sumHighestLowestFreq(freqMap);
    }

    private int sumHighestLowestFreq(Map<Integer, Integer> freqMap) {
        int lowestFreq = Integer.MAX_VALUE;
        int highestFreq = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            lowestFreq = Math.min(entry.getValue(), lowestFreq);
            highestFreq = Math.max(entry.getValue(), highestFreq);
        }
        return lowestFreq + highestFreq;
    }
}
