package com.dsa_series.roadmap.recursion.FAQs_Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        generateCombinations(k, n, currList, result);
        return result;
    }

    private void generateCombinations(int k, int targetSum, List<Integer> currList, List<List<Integer>> result) {

        if (currList.size() == k && targetSum == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }

        if (currList.size() > k || targetSum < 0) {
            return;
        }
        int elementTobeAdded = (currList.isEmpty()) ? 1 : currList.get(currList.size() - 1) + 1;

        for (int i = elementTobeAdded; i <= 9; i++) {
            if (i <= targetSum) {
                currList.add(i);
                generateCombinations(k, targetSum - i, currList, result);
                currList.remove(currList.size() - 1);
            }
        }
    }
}
