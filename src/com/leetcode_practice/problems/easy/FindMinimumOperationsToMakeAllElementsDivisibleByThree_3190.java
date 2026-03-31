package com.leetcode_practice.problems.easy;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree_3190 {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 3 != 0)
                count++;
        }
        return count;
    }

    // applicable for k
    public int minimumOperations_better(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int r = num % 3;
            count += Math.min(r, 3 - r);
        }
        return count;
    }
}
