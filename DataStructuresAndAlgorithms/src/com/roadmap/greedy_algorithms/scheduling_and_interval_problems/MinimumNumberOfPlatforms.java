package com.roadmap.greedy_algorithms.scheduling_and_interval_problems;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public int findPlatform_BF(int[] Arrival, int[] Departure) {
        int n = Arrival.length;
        int maxCount = 1;
        for (int i = 0; i < n; i++) {
            int platformCount = 1;
            for (int j = i + 1; j < n; j++) {
                /*
                 * Check if there is an overlap between
                 * the current train (i) and another train (j)
                 * 
                 * There is an overlap if:
                 * 
                 * 1. The arrival time of train i is between the
                 * arrival and departure times of train j
                 * 
                 * 2. OR the arrival time of train j is between
                 * the arrival and departure times of train i
                 */
                if (((Arrival[i] >= Arrival[j] && Arrival[i] <= Departure[j])
                        || (Arrival[j] >= Arrival[i] && Arrival[j] <= Departure[i]))) {
                    platformCount++;
                }
            }
            maxCount = Math.max(maxCount, platformCount);
        }
        return maxCount;
    }

    public int findPlatform_Optimal(int[] Arrival, int[] Departure) {
        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        int maxCount = 1;
        int i = 1, j = 0, n = Arrival.length;
        int count = 1;
        while (i < n) {
            if (Arrival[i] <= Departure[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
