package com.leetcode_practice.problems.easy;

public class BuildArrayFromPermutation_1920 {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = 0, j = n - 1;
        while (i <= j) {
            ans[i] = nums[nums[i]];
            ans[j] = nums[nums[j]];
            i++;
            j--;
        }
        return ans;
    }
}
