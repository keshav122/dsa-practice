package com.leetcode_practice.problems.easy;

public class FruitsIntoBasketsII_3477 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int unPlacedCount = 0;
        for (int i = 0; i < n; i++) {
            boolean isPlaced = false;
            for (int j = 0; j < n; j++) {
                if (baskets[j] >= fruits[i]) {
                    baskets[j] = -1;
                    isPlaced = true;
                    break;
                }
            }
            if (!isPlaced) {
                unPlacedCount++;
            }
        }
        return unPlacedCount;
    }
}
