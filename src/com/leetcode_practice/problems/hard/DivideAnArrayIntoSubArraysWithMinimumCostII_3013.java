package com.leetcode_practice.problems.hard;

import java.util.TreeMap;

public class DivideAnArrayIntoSubArraysWithMinimumCostII_3013 {

    TreeMap<Integer, Integer> chosen = new TreeMap<>();
    TreeMap<Integer, Integer> rest = new TreeMap<>();
    long sumChosen = 0;
    int chosenSize = 0;
    int restSize = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;

        // Initial window [1.. 1+dist]
        for (int i = 1; i <= Math.min(n - 1, 1 + dist); i++) {
            add(rest, nums[i], false);
        }
        rebalance(k);

        if (chosenSize == k - 1) {
            ans = sumChosen;
        }

        for (int l = 1, r = l + dist + 1; r < n; l++, r++) {

            // Remove outgoing
            int out = nums[l];
            if (chosen.containsKey(out)) {
                remove(chosen, out, true);
                sumChosen -= out;
            } else {
                remove(rest, out, false);
            }

            // Add incoming
            int in = nums[r];
            if (!chosen.isEmpty() && in < chosen.lastKey()) {
                add(chosen, in, true);
                sumChosen += in;
            } else {
                add(rest, in, false);
            }

            rebalance(k);

            if (chosenSize == k - 1) {
                ans = Math.min(ans, sumChosen);
            }
        }
        return nums[0] + ans;
    }

    private void rebalance(int k) {
        while (chosenSize < k - 1 && !rest.isEmpty()) {
            int x = rest.firstKey();
            remove(rest, x, false);
            add(chosen, x, true);
            sumChosen += x;
        }

        while (chosenSize > k - 1) {
            int x = chosen.lastKey();
            remove(chosen, x, true);
            sumChosen -= x;
            add(rest, x, false);
        }
    }

    private void add(TreeMap<Integer, Integer> map, int x, boolean isChosen) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        if (isChosen)
            chosenSize++;
        else
            restSize++;
    }

    private void remove(TreeMap<Integer, Integer> map, int x, boolean isChosen) {
        int cnt = map.get(x);
        if (cnt == 1)
            map.remove(x);
        else
            map.put(x, cnt - 1);

        if (isChosen)
            chosenSize--;
        else
            restSize--;
    }
}
