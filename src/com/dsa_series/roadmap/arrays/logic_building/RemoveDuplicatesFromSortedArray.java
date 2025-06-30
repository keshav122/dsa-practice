package com.dsa_series.roadmap.arrays.logic_building;

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

    public int removeDuplicatesOptimal(int[] nums) {
        if (nums.length == 0)
            return 0;
        int lastUniqueIndex = 0;
        for (int currIndex = 1; currIndex < nums.length; currIndex++) {
            if (nums[currIndex] != nums[lastUniqueIndex]) {
                lastUniqueIndex++;
                nums[lastUniqueIndex] = nums[currIndex];
            }
        }
        return lastUniqueIndex + 1;
    }
}
