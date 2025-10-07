package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFloodInTheCity_1488 {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                if (fullLakes.containsKey(rains[i])) {
                    int lastRainDay = fullLakes.get(rains[i]);
                    fullLakes.put(rains[i], i);
                    Integer dryDay = dryDays.higher(lastRainDay);
                    if (dryDay == null)
                        return new int[] {};
                    ans[dryDay] = rains[i];
                    dryDays.remove(dryDay);
                }
                fullLakes.put(rains[i], i);
                ans[i] = -1;

            }
        }
        return ans;
    }
}
