package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSpecialTriplets_3583 {

    // Not correct code
    public int specialTriplets_BF(int[] nums) {
        int n = nums.length;
        int MOD = (int) (1e9) + 7;
        // number - index map
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(i);
                map.put(nums[i], li);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            if (key == 0) {
                int size = map.get(key).size();
                long pairs = ((long) size * (size - 1) % MOD) * (size - 2) % MOD;
                long add = (pairs * 166666668L) % MOD; // modular inverse of 6
                count = (count + (int) add) % MOD;
                continue;
            }
            int twiceKey = key * 2;
            if (map.containsKey(twiceKey) && map.get(twiceKey).size() > 1) {
                for (int index : map.get(key)) {
                    int lessThanIndex = 0, moreThanIndex = 0;
                    for (Integer twiceKeyIndex : map.get(twiceKey)) {
                        if (twiceKeyIndex > index) {
                            moreThanIndex++;
                        } else {
                            lessThanIndex++;
                        }
                    }
                    count = (count + (moreThanIndex * lessThanIndex) % MOD) % MOD;
                }
            }
        }
        return count;
    }

    public int specialTriplets(int[] nums) {
        int MOD = (int)(1e9) + 7;
        int n = nums.length;
        Map<Integer, Long> freqPrev = new HashMap<>();
        Map<Integer, Long> freqNext = new HashMap<>();
        for (int num : nums) {
            freqNext.put(num, freqNext.getOrDefault(num, 0L) + 1);
        }

        int count = 0;
        for(int i = 0; i< )

    }
}
