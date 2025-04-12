package com.problems.easy;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsToMakeArrayElementsDistinct_3396 {
    public int minimumOperations(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (hashSet.contains(nums[i])) {
                return (i / 3 + 1);
            } else {
                hashSet.add(nums[i]);
            }
        }
        return 0;
    }
}
