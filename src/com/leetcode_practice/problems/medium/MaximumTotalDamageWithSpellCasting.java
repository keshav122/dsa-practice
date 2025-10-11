package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumTotalDamageWithSpellCasting {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> powerMap = new HashMap<>();
        for (int pow : power) {
            powerMap.merge(pow, (long) pow, Long::sum);
        }
        List<Integer> uniquePowers = new ArrayList<>(powerMap.keySet());
        Collections.sort(uniquePowers);
        return f(0, uniquePowers, powerMap);
    }

    private long f(int index, List<Integer> unique, Map<Integer, Long> powerMap) {

        if (index >= unique.size()) {
            return 0;
        }
        long notTake = f(index + 1, unique, powerMap);
        int curr = unique.get(index);
        long currDamage = powerMap.get(curr);
        int j = index + 1;
        while (j < unique.size() && unique.get(j) <= curr + 2) {
            j++;
        }
        long take = currDamage + f(j, unique, powerMap);
        return Math.max(take, notTake);
    }

    public long maximumTotalDamage_Mem(int[] power) {
        Map<Integer, Long> powerMap = new HashMap<>();
        for (int pow : power) {
            powerMap.merge(pow, (long) pow, Long::sum);
        }
        List<Integer> uniquePowers = new ArrayList<>(powerMap.keySet());
        Collections.sort(uniquePowers);
        long[] dp = new long[uniquePowers.size()];
        Arrays.fill(dp, -1);
        return f(0, uniquePowers, powerMap, dp);
    }

    private long f(int index, List<Integer> unique, Map<Integer, Long> powerMap, long[] dp) {

        if (index >= unique.size()) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        long notTake = f(index + 1, unique, powerMap, dp);
        int curr = unique.get(index);
        long currDamage = powerMap.get(curr);
        int j = index + 1;
        while (j < unique.size() && unique.get(j) <= curr + 2) {
            j++;
        }
        long take = currDamage + f(j, unique, powerMap, dp);
        return Math.max(take, notTake);
    }

    public long maximumTotalDamage_Tab(int[] power) {
        Map<Integer, Long> powerMap = new HashMap<>();
        for (int pow : power) {
            powerMap.merge(pow, (long) pow, Long::sum);
        }
        List<Integer> unique = new ArrayList<>(powerMap.keySet());
        Collections.sort(unique);
        int n = unique.size();
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            long notTake = dp[i + 1];
            int curr = unique.get(i);
            long currDamage = powerMap.get(curr);
            int j = i + 1;
            while (j < unique.size() && unique.get(j) <= curr + 2) {
                j++;
            }
            long take = currDamage + (j < n ? dp[j] : 0);
            dp[j] = Math.max(take, notTake);
        }
        return dp[0];
    }

}
