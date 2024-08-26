package com.roadmap.arrays.logic_building;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int currPointer = 1;
        int i = 1;
        int currElem = nums[0];
        while (i < nums.length) {
            if (nums[i] != currElem) {
                nums[currPointer] = currElem = nums[i];
                currPointer++;
            }
            i++;
        }
        return currPointer;
    }
}
