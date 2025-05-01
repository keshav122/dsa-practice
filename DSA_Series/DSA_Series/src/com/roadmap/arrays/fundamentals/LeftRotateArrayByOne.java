package com.roadmap.arrays.fundamentals;

public class LeftRotateArrayByOne {
    public void rotateArrayByOne(int[] nums) {
        int firstElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = firstElement;
    }
}
