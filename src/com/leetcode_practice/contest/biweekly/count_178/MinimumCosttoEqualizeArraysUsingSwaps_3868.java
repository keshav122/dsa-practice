package com.leetcode_practice.contest.biweekly.count_178;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumCosttoEqualizeArraysUsingSwaps_3868 {
    public int minCost(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (isIdentical(nums1, nums2, n))
            return 0;

        Set<Integer> hash = new HashSet<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash.add(nums1[i]);
            hash.add(nums2[i]);
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }

        int cost = 0;
        for (Integer it : hash) {
            int sum = map1.getOrDefault(it, 0) + map2.getOrDefault(it, 0);
            if (sum % 2 == 1)
                return -1;
            cost += (Math.abs(map1.getOrDefault(it, 0) - map2.getOrDefault(it, 0))) / 2;
        }

        return cost / 2;
    }

    private boolean isIdentical(int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }
}

class Solution_better {
    public int minCost(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Set<Integer> hash = new HashSet<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash.add(nums1[i]);
            hash.add(nums2[i]);
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }
        if (isIdentical(map1, map2))
            return 0;
        int cost = 0;
        for (Integer it : hash) {
            int sum = map1.getOrDefault(it, 0) + map2.getOrDefault(it, 0);
            if (sum % 2 == 1)
                return -1;
            cost += (Math.abs(map1.getOrDefault(it, 0) - map2.getOrDefault(it, 0))) / 2;
        }

        return cost / 2;
    }

    private boolean isIdentical(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        if (map1.size() != map2.size())
            return false;
        for (Integer it : map1.keySet()) {
            if (map1.get(it) != map2.getOrDefault(it, 0)) {
                return false;
            }
        }
        for (Integer it : map2.keySet()) {
            if (map2.get(it) != map1.getOrDefault(it, 0)) {
                return false;
            }
        }
        return true;
    }
}