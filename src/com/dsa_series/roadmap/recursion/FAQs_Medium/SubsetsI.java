/*Author: keshav122 */
package com.dsa_series.roadmap.recursion.FAQs_Medium;

import java.util.ArrayList;
import java.util.List;

public class SubsetsI {
    public List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        result.add(0);
        generateSubset(nums, 0, n, result, 0);
        return result;
    }

    private void generateSubset(int[] nums, int i, int n, List<Integer> result, int currentSum) {
        if (i == n) {
            return;
        }

        generateSubset(nums, i + 1, n, result, currentSum);
        currentSum += nums[i];
        result.add(currentSum);
        generateSubset(nums, i + 1, n, result, currentSum);
    }
}
