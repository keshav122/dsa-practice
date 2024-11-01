package com.problems.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfArray {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[i];
        }
        Arrays.sort(ans);
        Map<Integer, Integer> rankMap = new HashMap<>();
        int count = 1;
        for (int element : ans) {
            if (!rankMap.containsKey(element)) {
                rankMap.put(element, count);
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        return arr;
    }
}
