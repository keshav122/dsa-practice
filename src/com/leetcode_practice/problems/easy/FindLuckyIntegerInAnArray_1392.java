package com.leetcode_practice.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray_1392 {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int a : arr) {
            freqMap.merge(a, 1, Integer::sum);
        }
        int luckyInt = -1;
        for (Integer i : freqMap.keySet()) {
            if (i == freqMap.get(i) && i > luckyInt) {
                luckyInt = i;
            }
        }

        return luckyInt;
    }

    public int findLucky_const(int[] arr) {
        int[] hash = new int[501];
        for (int a : arr) {
            hash[a]++;
        }
        for (int i = 500; i > 0; i--) {
            if (hash[i] == i)
                return i;
        }
        return -1;
    }
}
