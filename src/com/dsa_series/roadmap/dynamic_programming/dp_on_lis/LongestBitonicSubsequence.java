package com.dsa_series.roadmap.dynamic_programming.dp_on_lis;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    public int LongestBitonicSequence(int[] arr) {
        int n = arr.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1, 1);
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[prev]);
                }
            }
        }

        int[] dp2 = new int[n];
        int maxi = 1;
        Arrays.fill(dp2, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = n - 1; prev > i; prev--) {
                if (arr[prev] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[prev]);
                }
            }
            maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        }
        return maxi;
    }
}
