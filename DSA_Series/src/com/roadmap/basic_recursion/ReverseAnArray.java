package com.roadmap.basic_recursion;

import java.util.ArrayList;

public class ReverseAnArray {
    public boolean isSorted(ArrayList<Integer> nums) {
        if (nums.size() == 1)
            return true;
        return isSorted(nums, 0);
    }

    private boolean isSorted(ArrayList<Integer> nums, int startIndex) {
        if (startIndex >= nums.size() - 1) {
            return true;
        }
        boolean smallAns = isSorted(nums, startIndex + 1);
        if (smallAns) {
            return nums.get(startIndex) <= nums.get(startIndex + 1);
        }
        return false;
    }
}
