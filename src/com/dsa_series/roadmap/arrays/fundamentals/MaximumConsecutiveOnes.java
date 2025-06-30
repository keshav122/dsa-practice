package com.dsa_series.roadmap.arrays.fundamentals;

public class MaximumConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, count);
            } else {
                count = 0;
            }
        }
        return maxConsecutiveOnes;
    }
}
