package com.leetcode_practice.problems.easy;

import java.util.Arrays;

public class MaximumProductOfTwoIntegerInAnArray_1464 {
    // O(NlogN)
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }

    public int maxProduct_Better(int[] nums) {
        int n = nums.length;
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // I often do mistake here by copying the secondLarget value later which gets
            // the largest value then
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }
        return (largest - 1) * (secondLargest - 1);
    }
}
