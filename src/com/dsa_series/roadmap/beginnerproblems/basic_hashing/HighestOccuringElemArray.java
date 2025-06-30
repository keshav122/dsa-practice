package com.dsa_series.roadmap.beginnerproblems.basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class HighestOccuringElemArray {
    public int mostFrequentElement(int[] nums) {
        // This map stores the frequency of the elements in the array
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int element : nums) {
            // This is a shorthand of implementing the check whether the element/key is
            // present in the map. If yes it adds 1 to the value present , else it adds a
            // default value as 1.
            freqMap.merge(element, 1, Integer::sum);
        }
        return maxFrequencyElement(freqMap);

    }

    // This method returns the max freq element from a map.
    private int maxFrequencyElement(Map<Integer, Integer> freqMap) {
        int maxFreq = 0;
        int maxFreqElement = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxFreqElement = entry.getKey();
            } else if (entry.getValue() == maxFreq) {
                maxFreqElement = Math.min(entry.getKey(), maxFreqElement);
            }
        }
        return maxFreqElement;
    }
}
