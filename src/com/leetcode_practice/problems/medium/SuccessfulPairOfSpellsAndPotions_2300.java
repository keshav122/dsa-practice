package com.leetcode_practice.problems.medium;

import java.util.Arrays;

public class SuccessfulPairOfSpellsAndPotions_2300 {
    public int[] successfulPairs_BF(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int spellStr = spells[i];
            int count = 0;
            for (int potion : potions) {

                // Mutiply with 1L first to ensure it is converted into long
                if (1L * potion * spellStr >= success) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int spellStr = spells[i];
            long valGreaterThan = (success + spellStr - 1) / (spellStr);
            int count = m - lowerBound(potions, valGreaterThan, m);
            ans[i] = count;
        }
        return ans;
    }

    private int lowerBound(int[] potions, long x, int m) {
        int low = 0;
        int high = m;
        while (low < high) {
            int mid = (low + high) / 2;
            if (potions[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
