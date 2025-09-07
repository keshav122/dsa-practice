package com.dsa_series.roadmap.dynamic_programming.dp_on_lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n], hash = new int[n];
        Arrays.fill(dp, 1);
        int lastIndex = 0, maxi = 1;
        for (int i = 1; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]) {
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
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 54, 72, 18, 72, 6, 54 };
        LargestDivisibleSubset obj = new LargestDivisibleSubset();
        List<Integer> li = obj.largestDivisibleSubset(nums);
        System.out.println(li.size());
        for (int num : li) {
            System.out.print(num + " ");
        }

    }
}
