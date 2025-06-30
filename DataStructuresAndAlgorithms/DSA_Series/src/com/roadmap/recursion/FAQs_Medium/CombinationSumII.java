package com.roadmap.recursion.FAQs_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        generateSubsequenceSet(candidates, target, currentList, result, 0, n);
        return result;

    }

    private void generateSubsequenceSet(int[] candidates, int target, List<Integer> currentList,
            List<List<Integer>> result, int index, int n) {
        if (target == 0) {
            List<Integer> li = new ArrayList<>(currentList);
            Collections.sort(li);
            if (!result.contains(li)) {
                result.add(li);
            }
            return;
        }

        if (index == n || target < 0) {
            return;
        }
        currentList.add(candidates[index]);
        generateSubsequenceSet(candidates, target - candidates[index], currentList, result, index + 1, n);
        currentList.remove(currentList.size() - 1);
        generateSubsequenceSet(candidates, target, currentList, result, index + 1, n);
    }

    public List<List<Integer>> combinationSum2_Better(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        generateSubsequenceSetOptimised(candidates, target, currentList, result, 0, n);
        return result;

    }

    private void generateSubsequenceSetOptimised(int[] candidates, int target, List<Integer> currentList,
            List<List<Integer>> result, int i, int n) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (i == n || target < 0) {
            return;
        }
        currentList.add(candidates[i]);
        generateSubsequenceSetOptimised(candidates, target - candidates[i], currentList, result, i + 1, n);
        currentList.remove(currentList.size() - 1);
        // As there can be duplicate elements lets say in a array of 1 2 2 2 5 , if we
        // say that we are not taking 2 then we should not take any '2' and directly
        // take 5 after the 1
        for (int j = i + 1; j < n; j++) {
            if (candidates[j] != candidates[i]) {
                generateSubsequenceSetOptimised(candidates, target, currentList, result, j, n);
                break;
            }
        }

    }
}
