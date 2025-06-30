package com.dsa_series.roadmap.bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSetDup {
    public List<List<Integer>> powerSet_BF(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> li = new ArrayList<>();
        generatePowerSet(0, res, li, nums);
        return res;
    }

    private void generatePowerSet(int index, List<List<Integer>> res, List<Integer> li, int[] nums) {
        int n = nums.length;
        if (index == n) {
            res.add(new ArrayList<>(li));
            return;
        }

        li.add(nums[index]);
        generatePowerSet(index + 1, res, li, nums);
        li.remove(li.size() - 1);
        generatePowerSet(index + 1, res, li, nums);
    }

    // Optimal Solution
    public List<List<Integer>> powerSet(int[] nums) {
        int n = nums.length;
        List<List<Integer>> powerSetRes = new ArrayList<>();
        int subsets = (1 << n);
        for (int i = 0; i < subsets; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            powerSetRes.add(list);
        }
        return powerSetRes;
    }
}
