package com.dsa_series.roadmap.stacks_and_queues.FAQs;

public class TrappingRainWater {

    public int trap_BF(int[] height) {
        // Water trapped between any two buildings (min(leftmax, rightmax) - height of
        // building)
        // the summation of these indiviual trappped water units will give us the total
        // trapped water
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(height[i], prefixMax[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(height[i], suffixMax[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        return sum;
    }

    public int trap_better(int[] height) {
        int n = height.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(height[i], suffixMax[i + 1]);
        }
        int sum = 0;
        int leftMax = height[0];
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            sum += Math.min(leftMax, suffixMax[i]) - height[i];
        }
        return sum;
    }

    public int trap(int[] height) {
        int l = 0, r = height.length - 1, leftMax = 0, rightMax = 0, total = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (leftMax > height[l]) {
                    total += leftMax - height[l];
                } else {
                    leftMax = height[l];
                }
                l++;
            } else {
                if (rightMax > height[r]) {
                    total += rightMax - height[r];
                } else {
                    rightMax = height[r];
                }
                r--;
            }
        }
        return total;
    }
}
