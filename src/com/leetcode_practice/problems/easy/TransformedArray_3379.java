package com.leetcode_practice.problems.easy;

public class TransformedArray_3379 {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else if (nums[i] > 0) {
                int idx = (i + (nums[i] % n)) % n;
                result[i] = nums[idx];
            } else {
                int idx = (i - (Math.abs(nums[i]) % n) + n) % n;
                result[i] = nums[idx];
            }
        }
        return result;
    }

    public int[] constructTransformedArray_better(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
                continue;
            }
            int shift = nums[i] % n;
            int idx = (i + shift) % n;
            if (idx < 0)
                idx += n;
            result[i] = nums[idx];
        }
        return result;
    }
}
