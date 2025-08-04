package com.leetcode_practice.problems.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// basket1 =
// [84,80,43,8,80,88,43,14,100,88]
// basket2 =
// [32,32,42,68,68,100,42,84,14,8]

//Try for the given use case - to understand the logic of minElement
public class RearrangingFruits_2561 {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Integer> freqMap1 = new HashMap<>();
        Map<Integer, Integer> freqMap2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freqMap1.merge(basket1[i], 1, Integer::sum);
            freqMap2.merge(basket2[i], 1, Integer::sum);
        }
        Set<Integer> allKeys = new HashSet<>();
        allKeys.addAll(freqMap1.keySet());
        allKeys.addAll(freqMap2.keySet());

        List<Integer> extras1 = new ArrayList<>();
        List<Integer> extras2 = new ArrayList<>();
        int minElement = Integer.MAX_VALUE;
        for (int key : allKeys) {
            int count1 = freqMap1.getOrDefault(key, 0);
            int count2 = freqMap2.getOrDefault(key, 0);
            minElement = Math.min(minElement, key);
            int diff = count1 - count2;
            if (diff % 2 != 0)
                return -1;
            if (diff > 0) {
                for (int i = 0; i < diff / 2; i++)
                    extras1.add(key);
            } else if (diff < 0) {
                for (int i = 0; i < -diff / 2; i++)
                    extras2.add(key);
            }
        }

        Collections.sort(extras1);
        Collections.sort(extras2, Collections.reverseOrder());

        long cost = 0;
        for (int i = 0; i < extras1.size(); i++) {
            cost += Math.min(
                    Math.min(extras1.get(i), extras2.get(i)),
                    2 * minElement);
        }
        return cost;
    }
}
