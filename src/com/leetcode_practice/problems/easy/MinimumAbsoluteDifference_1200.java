package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference_1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                res.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return res;
    }
}
