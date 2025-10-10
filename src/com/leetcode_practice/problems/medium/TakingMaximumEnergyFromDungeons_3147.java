package com.leetcode_practice.problems.medium;

public class TakingMaximumEnergyFromDungeons_3147 {
    public int maximumEnergy_BF(int[] energy, int k) {
        int maxEnergy = -(int) (1e9);
        int n = energy.length;
        for (int i = 0; i < n; i++) {
            int engy = 0;
            int j = i;
            while (j < n) {
                engy += energy[j];
                j += k;
            }
            maxEnergy = Math.max(engy, maxEnergy);
        }
        return maxEnergy;
    }

    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] energySum = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            energySum[i] = energy[i];
            if (i + k < n) {
                energySum[i] += energySum[i + k];
            }
        }

        int maxEnergy = -(int) (1e9);
        for (int engy : energySum) {
            maxEnergy = Math.max(maxEnergy, engy);
        }
        return maxEnergy;
    }

    // Not much recommended because we do not generally modify input array
    public int maximumEnergy_InPlace(int[] energy, int k) {
        int n = energy.length;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n) {
                energy[i] += energy[i + k];
            }
        }

        int maxEnergy = -(int) (1e9);
        for (int engy : energy) {
            maxEnergy = Math.max(maxEnergy, engy);
        }
        return maxEnergy;
    }
}
