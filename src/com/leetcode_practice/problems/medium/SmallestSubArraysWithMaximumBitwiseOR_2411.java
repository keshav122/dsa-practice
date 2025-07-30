package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class SmallestSubArraysWithMaximumBitwiseOR_2411 {

    public int[] smallestSubarrays_BF(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int minLen = 1;
            int maxOR = nums[i];
            int currOR = nums[i];
            for (int j = i + 1; j < n; j++) {
                currOR = currOR | nums[j];
                if (currOR > maxOR) {
                    maxOR = currOR;
                    minLen = j - i + 1;
                }
            }
            ans[i] = minLen;
        }
        return ans;
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        // To get the last set bit position
        int[] last = new int[32];
        Arrays.fill(last, -1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 32; j++) {
                if (((nums[i] >> j) & 1) == 1) {
                    last[j] = i;
                }
            }
            int maxDist = i;
            for (int j = 0; j < 32; j++) {
                if (last[j] != -1) {
                    maxDist = Math.max(maxDist, last[j]);
                }
            }
            ans[i] = maxDist - i + 1;
        }
        return ans;
    }
}
