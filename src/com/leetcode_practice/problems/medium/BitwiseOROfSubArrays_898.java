package com.leetcode_practice.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class BitwiseOROfSubArrays_898 {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> subArrOrSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int currOR = arr[i];
            subArrOrSet.add(currOR);
            for (int j = i + 1; j < n; j++) {
                currOR |= arr[j];
                subArrOrSet.add(currOR);
            }
        }
        return subArrOrSet.size();
    }

    // Revise
    public int subarrayBitwiseORs_Optimal(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int a : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(a);
            for (int num : prev) {
                curr.add(a | num);
            }
            ans.addAll(curr);
            prev = curr;
        }
        return ans.size();
    }
}
