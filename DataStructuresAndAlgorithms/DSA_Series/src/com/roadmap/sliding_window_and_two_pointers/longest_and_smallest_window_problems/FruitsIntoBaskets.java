package com.roadmap.sliding_window_and_two_pointers.longest_and_smallest_window_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsIntoBaskets {

    public int totalFruits_BF(int[] fruits) {
        int n = fruits.length;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i; j < n; j++) {
                st.add(fruits[j]);
                if (st.size() <= 2) {
                    maxCount = Math.max(maxCount, j - i + 1);
                } else {
                    break;
                }

            }
        }
        return maxCount;
    }

    public int totalFruits_optimal(int[] fruits) {
        int n = fruits.length;
        int maxCount = 0, l = 0, r = 0;
        Set<Integer> st = new HashSet<>();
        while (r < n) {
            st.add(fruits[r]);
            if (st.size() > 2) {
                // move the l to position
                int i = r - 1;
                while (fruits[i] != fruits[l]) {
                    i--;
                }
                st.remove(fruits[l]);
                l = i + 1;
            }
            maxCount = Math.max(maxCount, r - l + 1);
            r++;
        }
        return maxCount;
    }

    public int totalFruits_BetterMapBased(int[] fruits) {
        int n = fruits.length, l = 0, r = 0, maxCount = 0;
        Map<Integer, Integer> fruitFreqMap = new HashMap<>();
        while (r < n) {
            fruitFreqMap.merge(fruits[r], 1, Integer::sum);
            if (fruitFreqMap.size() > 2) {
                while (fruitFreqMap.size() > 2) {
                    fruitFreqMap.put(fruits[l], fruitFreqMap.get(fruits[l]) - 1);
                    if (fruitFreqMap.get(fruits[l]) == 0) {
                        fruitFreqMap.remove(fruits[l]);
                    }
                    l++;
                }
            }

            if (fruitFreqMap.size() <= 2) {
                maxCount = Math.max(maxCount, r - l + 1);
            }

            r++;
        }
        return maxCount;
    }

    public int totalFruits_optimalMapBased(int[] fruits) {
        int n = fruits.length, l = 0, r = 0, maxCount = 0;
        Map<Integer, Integer> fruitFreqMap = new HashMap<>();
        while (r < n) {
            fruitFreqMap.merge(fruits[r], 1, Integer::sum);
            if (fruitFreqMap.size() > 2) {
                fruitFreqMap.put(fruits[l], fruitFreqMap.get(fruits[l]) - 1);
                if (fruitFreqMap.get(fruits[l]) == 0) {
                    fruitFreqMap.remove(fruits[l]);
                }
                l++;
            }

            if (fruitFreqMap.size() <= 2) {
                maxCount = Math.max(maxCount, r - l + 1);
            }

            r++;
        }
        return maxCount;
    }
}
