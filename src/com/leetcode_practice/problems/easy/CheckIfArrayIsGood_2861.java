package com.leetcode_practice.problems.easy;

public class CheckIfArrayIsGood_2861 {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] hash = new int[n];
        for (int i = 0; i <= n; i++) {
            if (nums[i] > n)
                return false;
            hash[nums[i] - 1]++;
        }
        for (int i = 0; i < n - 1; i++) {
            if (hash[i] != 1)
                return false;
        }
        return hash[n - 1] == 2;
    }
}