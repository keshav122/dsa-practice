/*Author: keshav122 */
package com.leetcode_practice.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumPopulationYear_1854 {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] year : logs) {
            for (int i = year[0]; i < year[1]; i++) {
                freq.put(i, freq.getOrDefault(i, 0) + 1);
            }
        }

        int maxPopulation = 1;
        int maxPopulationYear = logs[0][0];
        for (Integer key : freq.keySet()) {
            if (freq.get(key) > maxPopulation) {
                maxPopulation = freq.get(key);
                maxPopulationYear = key;
            } else if (freq.get(key) == maxPopulation) {
                maxPopulationYear = Math.min(maxPopulationYear, key);
            }

        }
        return maxPopulationYear;
    }

    public int maximumPopulation_better(int[][] logs) {
        int[] years = new int[2051];
        for (int[] year : logs) {
            years[year[0]]++;
            years[year[1]]--;
        }

        int maxPopulation = 0;
        int maxPopulationYear = logs[0][0];
        int curr = 0;
        for (int i = 1950; i <= 2050; i++) {
            curr += years[i];
            if (curr > maxPopulation) {
                maxPopulation = curr;
                maxPopulationYear = i;
            }
        }
        return maxPopulationYear;
    }
}
