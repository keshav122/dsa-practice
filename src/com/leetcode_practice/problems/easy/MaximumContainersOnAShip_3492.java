package com.leetcode_practice.problems.easy;

public class MaximumContainersOnAShip_3492 {
    public int maxContainers(int n, int w, int maxWeight) {
        return (n * n * w <= maxWeight) ? n * n : maxWeight / w;
    }

    // Logic : Number of containers ≤ space limit
    // Number of containers ≤ weight limit
    // Final Answer : min(space limit, weight limit)
    public int maxContainers_Cleaner(int n, int w, int maxWeight) {
        return (n * n * w <= maxWeight) ? n * n : maxWeight / w;
    }

}
