package com.roadmap.recursion.FAQs_Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        generateSubsequenceSet(candidates, target, currentList, result, 0, n);
        return result;

    }

    private void generateSubsequenceSet(int[] candidates, int target, List<Integer> currentList,
            List<List<Integer>> result, int index, int n) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (index == n || target < 0) {
            return;
        }
        currentList.add(candidates[index]);
        generateSubsequenceSet(candidates, target - candidates[index], currentList, result, index, n);
        currentList.remove(currentList.size() - 1);
        generateSubsequenceSet(candidates, target, currentList, result, index + 1, n);
    }

}
