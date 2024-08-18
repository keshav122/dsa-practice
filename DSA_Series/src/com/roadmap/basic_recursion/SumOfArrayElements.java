package com.roadmap.basic_recursion;

public class SumOfArrayElements {
    public int arraySum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return arraySum(nums, 0);
    }

    private int arraySum(int[] nums, int startIndex) {
        if (startIndex >= nums.length) {
            return 0;
        }
        int smallSum = arraySum(nums, startIndex + 1);
        return nums[startIndex] + smallSum;
    }
}
