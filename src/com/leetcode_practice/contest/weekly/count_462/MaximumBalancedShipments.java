package com.leetcode_practice.contest.weekly.count_462;

public class MaximumBalancedShipments {
    public static int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int i = 1;
        int currMaxWt = weight[0];
        int balancedShipmentCount = 0;
        while (i < n) {
            if (weight[i] < currMaxWt) {
                balancedShipmentCount++;
                if (i != n - 1) {
                    currMaxWt = weight[i + 1];
                }
            } else if (weight[i] > currMaxWt) {
                currMaxWt = weight[i];
            }
            i++;
        }
        return balancedShipmentCount;
    }

    public static void main(String[] args) {
        int[] weight = { 2, 4, 4, 3 };
        System.out.println(maxBalancedShipments(weight));
    }
}
