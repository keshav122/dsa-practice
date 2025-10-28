package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class MakeArrayElementsEqualToZero_3354 {
    public int countValidSelections(int[] nums) {
        List<Integer> zeroIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndices.add(i);
            }
        }

        int count = 0;
        for (Integer ind : zeroIndices) {
            if (isValid(nums, ind, true))
                count++;
            if (isValid(nums, ind, false))
                count++;
        }
        return count;
    }

    private boolean isValid(int[] nums, int startingIndex, boolean isMovingRight) {
        int n = nums.length;
        int[] temp = nums.clone();

        int j = startingIndex;
        while (j < n && j >= 0) {
            j += isMovingRight ? 1 : -1;
            if (j >= n || j < 0) {
                break;
            }
            if (temp[j] > 0) {
                temp[j] = temp[j] - 1;
                isMovingRight = !isMovingRight;
            }
        }
        for (int num : temp) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}