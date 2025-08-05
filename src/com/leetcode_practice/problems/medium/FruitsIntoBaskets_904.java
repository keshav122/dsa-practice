package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsIntoBaskets_904 {
    public int totalFruit_BF(int[] fruits) {
        int n = fruits.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> fruitSet = new HashSet<>();
            for (int j = i; j < n; j++) {
                fruitSet.add(fruits[j]);
                if (fruitSet.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxLen;
    }

    public int totalFruit_Better(int[] fruits) {
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        while (r < fruits.length) {
            freqMap.merge(fruits[r], 1, Integer::sum);
            while (freqMap.size() > 2) {
                freqMap.put(fruits[l], freqMap.get(fruits[l]) - 1);
                if (freqMap.get(fruits[l]) == 0) {
                    freqMap.remove(fruits[l]);
                }
                l++;
            }
            if (freqMap.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

    public int totalFruit_Optimal(int[] fruits) {
        int l = 0, r = 0, maxLen = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        while (r < fruits.length) {
            freqMap.merge(fruits[r], 1, Integer::sum);
            if (freqMap.size() > 2) {
                freqMap.put(fruits[l], freqMap.get(fruits[l]) - 1);
                if (freqMap.get(fruits[l]) == 0) {
                    freqMap.remove(fruits[l]);
                }
                l++;
            }
            if (freqMap.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }

}
