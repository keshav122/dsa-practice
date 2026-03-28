package com.leetcode_practice.problems.easy;

public class ShuffleTheArray_1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int i = 0, j = n, k = 0;
        while (k < (2 * n)) {
            if (k % 2 == 0) {
                ans[k] = nums[i];
                i++;
            } else {
                ans[k] = nums[j];
                j++;
            }
            k++;
        }
        return ans;
    }

    public int[] shuffle_cleaner(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }
}
