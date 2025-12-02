package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfTrapeZoidsI_3623 {
    public int countTrapezoids(int[][] points) {
        int MODULO = (int) (1e9) + 7;
        Map<Integer, Integer> yGroup = new HashMap<>();
        for (int[] point : points) {
            yGroup.put(point[1], yGroup.getOrDefault(point[1], 0) + 1);
        }

        // TotalSegments = sum(pairs[i])
        // answer = (TotalSegments^2 - sum(pairs[i]^2)) / 2
        long totalSegment = 0;
        long pairSqSum = 0;
        long inv2 = 500000004L; // inverse of 2 % MODULO
        // pair[i] = i C2 => i * (i-1)/2
        for (Integer yC : yGroup.keySet()) {
            long p = yGroup.get(yC);
            long pair = (p * (p - 1) % MODULO * inv2) % MODULO;
            long pairSq = (pair * pair) % MODULO;
            pairSqSum = (pairSqSum + pairSq) % MODULO;
            totalSegment = (totalSegment + pair) % MODULO;
        }

        long tSSq = (totalSegment * totalSegment) % MODULO;
        long num = (tSSq - pairSqSum + MODULO) % MODULO;
        long ans = num * inv2 % MODULO;
        return (int) (ans);
    }
}
