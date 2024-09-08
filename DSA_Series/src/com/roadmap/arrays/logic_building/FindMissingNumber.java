package com.roadmap.arrays.logic_building;

public class FindMissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int naturalSum = ((n + 1) * n) / 2;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return Math.abs(naturalSum - sum);
    }
}
