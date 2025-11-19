package com.leetcode_practice.problems.easy;

public class AlteastKPlacesApart_1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIndex != -1 && (i - lastIndex) <= k) {
                    return false;
                } else {
                    lastIndex = i;
                }
            }
        }

        return true;
    }
}