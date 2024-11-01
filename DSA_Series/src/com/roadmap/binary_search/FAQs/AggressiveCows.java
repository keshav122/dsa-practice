package com.roadmap.binary_search.FAQs;

import java.util.Arrays;

public class AggressiveCows {
    public int aggressiveCows_BF(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxDistance = nums[n - 1] - nums[0];
        int ans = 1;
        for (int dist = 1; dist <= maxDistance; dist++) {
            if (cowsPlaced(nums, dist, n) >= k) {
                ans = dist;
            } else {
                return ans;
            }
        }
        return ans;
    }

    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int maxDistance = nums[n - 1] - nums[0];
        int lowDistance = 1;
        while (lowDistance <= maxDistance) {
            int midDistance = (lowDistance + maxDistance) / 2;
            if (cowsPlaced(nums, midDistance, n) >= k) {
                lowDistance = midDistance + 1;
            } else {
                maxDistance = midDistance - 1;
            }
        }
        return maxDistance;
    }

    private int cowsPlaced(int[] nums, int dist, int n) {
        int placedCowsCount = 1;
        int currentPos = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] - currentPos >= dist) {
                placedCowsCount++;
                currentPos = nums[i];
            }
        }
        return placedCowsCount;
    }
}
