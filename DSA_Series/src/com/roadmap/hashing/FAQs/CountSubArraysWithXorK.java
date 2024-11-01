package com.roadmap.hashing.FAQs;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithXorK {
    public int subarraysWithXorK_BF(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int xor = 0;
            for (int j = i; j < nums.length; j++) {
                xor ^= nums[j];
                if (xor == k)
                    count++;
            }
        }
        return count;
    }

    public int subarraysWithXorK(int[] nums, int k) {
        Map<Integer, Integer> xorMap = new HashMap<>();
        int count = 0;
        int xor = 0;
        xorMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            if (xorMap.containsKey(k ^ xor)) {
                count += xorMap.get(k ^ xor);
            }
            xorMap.merge(xor, 1, Integer::sum);
        }
        return count;
    }
}
