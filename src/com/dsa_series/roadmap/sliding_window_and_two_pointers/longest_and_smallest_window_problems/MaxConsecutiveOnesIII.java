package com.dsa_series.roadmap.sliding_window_and_two_pointers.longest_and_smallest_window_problems;

public class MaxConsecutiveOnesIII {
    public int longestOnes_BF(int[] nums, int k) {
        int n = nums.length, maxLen = 0;

        for (int i = 0; i < n; i++) {
            int zeros = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }

                if (zeros <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }

    public int longestOnes_better(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, maxLen = 0;
        int zeros = 0;
        while (r < n) {
            if (nums[r] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public int longestOnes_Optimal(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, maxLen = 0;
        int zeros = 0;
        while (r < n) {
            if (nums[r] == 0) {
                zeros++;
            }
            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            if (zeros <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }

            r++;
        }
        return maxLen;
    }

}
