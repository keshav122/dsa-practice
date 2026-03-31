package com.leetcode_practice.problems.easy;

import java.util.Arrays;

public class SquaresOfSortedArray_977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares_better(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1, k = n - 1;
        int[] ans = new int[n];
        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq >= rightSq) {
                ans[k--] = leftSq;
                left++;
            } else {
                ans[k--] = rightSq;
                right--;
            }
        }
        return ans;
    }
}
