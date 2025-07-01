package com.dsa_series.roadmap.hashing.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumPointsOnALine {
    // TODO : Not working solution
    public int maximumPointsOnALine(int[][] nums) {
        // the slope will be the same
        // slope between two points is calculated by (y2-y1)/(x2-x1)
        Map<Integer, Set<int[]>> slopeFreqMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int slope = Integer.MAX_VALUE;
                if (nums[j][0] != nums[i][0]) {
                    slope = (nums[j][1] - nums[i][1]) / (nums[j][0] - nums[i][0]);
                }

                if (slopeFreqMap.containsKey(slope)) {
                    slopeFreqMap.get(slope).add(nums[i]);
                    slopeFreqMap.get(slope).add(nums[j]);
                } else {
                    Set<int[]> set = new HashSet<>();
                    set.add(nums[i]);
                    set.add(nums[j]);
                    slopeFreqMap.put(slope, set);
                }
            }
        }
        int maxLen = 0;
        for (Map.Entry<Integer, Set<int[]>> entry : slopeFreqMap.entrySet()) {
            maxLen = Math.max(entry.getValue().size(), maxLen);
        }
        return maxLen;
    }
}
