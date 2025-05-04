package com.roadmap.arrays.contest;

public class MaximumConsecutiveGoodNumbers {
    public int maxConsecutiveGoodNums(int[] nums, int[] goodNumbers) {
        Set<Integer> goodNosList = new HashSet<>();
        for (int goodNumber : goodNumbers) {
            goodNosList.add(goodNumber);
        }
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (goodNosList.contains(nums[i])) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }
}
