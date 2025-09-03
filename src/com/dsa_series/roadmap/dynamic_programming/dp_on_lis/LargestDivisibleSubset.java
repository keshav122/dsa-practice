package com.dsa_series.roadmap.dynamic_programming.dp_on_lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n], hash = new int[n];
        Arrays.fill(dp, 1);
        int lastIndex = 0, maxi = 1;
        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                boolean isDivisible = (nums[i] % nums[prev] == 0) || (nums[prev] % nums[i] == 0);
                if (isDivisible && 1 + dp[prev] > dp[i]) {
                    hash[i] = prev;
                    dp[i] = 1 + dp[prev];
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
