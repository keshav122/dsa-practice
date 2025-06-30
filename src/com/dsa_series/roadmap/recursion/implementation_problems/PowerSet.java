package com.dsa_series.roadmap.recursion.implementation_problems;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        generatePowerSet(0, list, nums, result, n);
        return result;
    }

    private void generatePowerSet(int i, List<Integer> list, int[] nums, List<List<Integer>> result, int n) {
        if (i == n) {
            // Do not do this (result.add(list)) as the list will be modified during the
            // recursion
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        generatePowerSet(i + 1, list, nums, result, n);
        // Removing last element to change the list to its original form
        list.remove(list.size() - 1);
        generatePowerSet(i + 1, list, nums, result, n);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        PowerSet powerSet = new PowerSet();
        List<List<Integer>> ans = powerSet.powerSet(nums);
        for (List<Integer> li : ans) {
            for (Integer i : li) {
                System.out.println(i + " ");
            }
        }

    }
}
