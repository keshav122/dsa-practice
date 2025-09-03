/*Author: keshav122 */
package com.dsa_series.roadmap.beginnerproblems.basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class SecondHighestOccuringElem {
    public int secondMostFrequentElement(int[] nums) {
        // This map stores the frequency of the elements in the array
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int element : nums) {
            freqMap.merge(element, 1, Integer::sum);
        }
        return secondMaxFreqElement(freqMap);
    }

    private int secondMaxFreqElement(Map<Integer, Integer> freqMap) {
        int maxFreq = 0;
        int maxFreqElement = 0;
        int secondMaxFreq = 0;
        int secondMaxFreqElement = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                secondMaxFreq = maxFreq;
                secondMaxFreqElement = maxFreqElement;
                maxFreq = entry.getValue();
                maxFreqElement = entry.getKey();
            } else if (entry.getValue() > secondMaxFreq && entry.getValue() < maxFreq) {
                secondMaxFreq = entry.getValue();
                secondMaxFreqElement = entry.getKey();
            } else if (entry.getValue() == secondMaxFreq) {
                secondMaxFreqElement = Math.min(entry.getKey(), secondMaxFreqElement);
            }
        }
        if (secondMaxFreqElement == 0) {
            return -1;
        }
        return secondMaxFreqElement;
    }
}
