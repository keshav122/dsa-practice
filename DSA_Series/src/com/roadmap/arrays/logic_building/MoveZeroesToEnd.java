package com.roadmap.arrays.logic_building;

public class MoveZeroesToEnd {
    public void moveZeroesBF(int[] nums) {
        int currPointer = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[currPointer] = nums[i];
                currPointer++;
            }
            i++;
        }
        while (currPointer < nums.length) {
            nums[currPointer] = 0;
            currPointer++;
        }
    }
}
