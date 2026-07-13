/*Author: keshav122 */
package com.dsa_series.roadmap.beginnerproblems.basic_hashing;

import java.util.HashMap;
import java.util.Map;

public class SecondHighestOccuringElem {

    public int secondMostFrequentElement_optimal(int[] nums) {
        int maxFreq = 0, secondMaxFreq = 0;
        int maxEle = -1, secEle = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            int ele = it.getKey();
            int freq = it.getValue();

            if (freq > maxFreq) {
                secondMaxFreq = maxFreq;
                maxFreq = freq;
                secEle = maxEle;
                maxEle = ele;
            } else if (freq == maxFreq) {
                maxEle = Math.min(ele, maxEle);
            } else if (freq > secondMaxFreq) {
                secondMaxFreq = freq;
                secEle = ele;
            } else if (freq == secondMaxFreq) {
                secEle = Math.min(ele, secEle);
            }
        }
        return secEle;
    }

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
