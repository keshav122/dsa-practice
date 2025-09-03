package com.dsa_series.roadmap.dynamic_programming.dp_on_lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLIS {
    public List<Integer> longestIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n], hash = new int[n];
        Arrays.fill(dp, 1);
        int lastIndex = 0, maxi = 1;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(arr[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            res.add(arr[lastIndex]);
        }
        Collections.reverse(res);
        return res;
    }
}
