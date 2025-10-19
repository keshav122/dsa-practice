package com.leetcode_practice.problems.easy;

import java.util.List;

public class AdjacentIncreasingSubArrraysDetectionI_3349 {

    public boolean hasIncreasingSubarrays_BF(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i <= (n - 2 * k); i++) {
            boolean firstArr = isIncreasing(nums, i, i + k - 1);
            if (firstArr) {
                boolean secondArr = isIncreasing(nums, i + k, i + 2 * k - 1);
                if (firstArr && secondArr)
                    return true;
            }

        }
        return false;
    }

    private boolean isIncreasing(List<Integer> nums, int sI, int eI) {
        while (sI < eI) {
            if (nums.get(sI) >= nums.get(sI + 1)) {
                return false;
            }
            sI++;
        }
        return true;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 0;
        for (int i = 1; i < n; i++) {
            inc[i] = nums.get(i) > nums.get(i - 1) ? inc[i - 1] + 1 : 1;
        }
        for (int i = 0; i <= n - 2 * k; i++) {
            if (inc[i + k - 1] >= k && inc[i + 2 * k - 1] >= k) {
                return true;
            }
        }
        return false;
    }

}
