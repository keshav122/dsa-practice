package com.leetcode_practice.problems.easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInArray2N_960 {

    public int repeatedNTimes_BF(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return nums[0];

    }

    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
