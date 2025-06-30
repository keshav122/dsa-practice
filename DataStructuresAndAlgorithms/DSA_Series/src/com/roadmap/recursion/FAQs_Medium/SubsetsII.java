package com.roadmap.recursion.FAQs_Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        int n = nums.length;
        generateSubsetsWithDup(nums, result, li, 0, n);
        return result;
    }

    private void generateSubsetsWithDup(int[] nums, List<List<Integer>> result, List<Integer> li, int index, int n) {
        if (index == n) {
            List<Integer> list = new ArrayList<>(li);
            Collections.sort(list);
            if (!result.contains(list)) {
                result.add(list);
            }
            return;
        }
        li.add(nums[index]);
        generateSubsetsWithDup(nums, result, li, index + 1, n);
        li.remove(li.size() - 1);
        generateSubsetsWithDup(nums, result, li, index + 1, n);
    }
}
