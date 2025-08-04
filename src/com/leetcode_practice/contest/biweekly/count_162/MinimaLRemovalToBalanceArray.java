package com.leetcode_practice.contest.biweekly.count_162;

import java.util.Arrays;

public class MinimaLRemovalToBalanceArray {
    // Not correct
    public static int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        long minVal = nums[0] * k;
        if (minVal >= nums[n - 1])
            return 0;
        int count = 0;
        int low = 0, high = n - 1;
        while (low < high) {
            if ((long) (nums[low] * k) < nums[high]) {
                if ((long) (nums[low] * k) >= nums[low + 1]) {
                    high--;
                    count++;
                } else {
                    low++;
                    count++;
                }
            } else {
                break;
            }
        }
        return count;
    }

    public static int minRemoval_Correct(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxLen = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            while ((long) nums[j] > 1L * nums[i] * k) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return n - maxLen;
    }

    public static void main(String[] args) {
        int[] nums = { 68, 54, 14, 59 };
        int k = 4;
        // expected 2 giving 3
        System.out.println(minRemoval(nums, k));
    }
}
