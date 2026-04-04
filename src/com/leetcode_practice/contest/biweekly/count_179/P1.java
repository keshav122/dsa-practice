package com.leetcode_practice.contest.biweekly.count_179;

import java.util.ArrayList;
import java.util.List;

public class P1 {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        List<Integer> oneIndices = new ArrayList<>();
        List<Integer> twoIndices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                oneIndices.add(i);
            } else if (nums[i] == 2) {
                twoIndices.add(i);
            }
        }
        if (oneIndices.isEmpty() || twoIndices.isEmpty())
            return -1;
        int minDiff = Integer.MAX_VALUE;
        for (Integer one : oneIndices) {
            for (Integer two : twoIndices) {
                minDiff = Math.min(minDiff, Math.abs(one - two));
            }
        }
        return minDiff;
    }
}
