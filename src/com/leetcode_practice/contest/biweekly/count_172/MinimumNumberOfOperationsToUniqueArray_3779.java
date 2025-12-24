package com.leetcode_practice.contest.biweekly.count_172;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumNumberOfOperationsToUniqueArray_3779 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        Set<Integer> duplicateNos = new HashSet<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            if (freqMap.get(num) > 1) {
                duplicateNos.add(num);
            }
        }
        if (duplicateNos.isEmpty())
            return 0;
        int i = 0;
        int count = 0;
        while (i < n && duplicateNos.size() > 0) {
            count++;
            int j = i;
            while (j < n && j <= i + 2) {
                int val = freqMap.get(nums[j]) - 1;
                freqMap.put(nums[j], val);
                if (val <= 1 && duplicateNos.contains(nums[j])) {
                    duplicateNos.remove(nums[j]);
                }
                j++;
            }
            i = j;

        }
        return count;

    }

    public int minOperations_better(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        int i = n - 1;
        while (i >= 0) {
            if (seen.contains(nums[i])) {
                break;
            }
            seen.add(nums[i]);
            i--;
        }
        int elementsToRemove = (i + 1);
        return (elementsToRemove + 2) / 3;
    }
}
