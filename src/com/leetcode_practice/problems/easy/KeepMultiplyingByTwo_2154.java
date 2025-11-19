package com.leetcode_practice.problems.easy;

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingByTwo_2154 {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        while (true) {
            if (set.contains(original)) {
                original = 2 * original;
            } else {
                return original;
            }
        }

    }
}
