package com.leetcode_practice.problems.medium;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int width = j - i;
            int length = 0;
            if (height[i] <= height[j]) {
                length = height[i];
                i++;
            } else {
                length = height[j];
                j--;
            }
            maxArea = length * width > maxArea ? length * width : maxArea;
        }
        return maxArea;
    }
}
