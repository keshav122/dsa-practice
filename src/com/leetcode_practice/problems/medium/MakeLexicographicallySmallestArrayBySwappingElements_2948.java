package com.leetcode_practice.problems.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeLexicographicallySmallestArrayBySwappingElements_2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new int[] { nums[i], i });
        }
        pairs.sort((a, b) -> (a[0] - b[0]));
        int[] res = new int[n];
        int i = 0;
        while (i < n) {
            List<int[]> group = new ArrayList<>();
            group.add(pairs.get(i));

            int j = i + 1;
            while (j < n && pairs.get(j)[0] - pairs.get(j - 1)[0] <= limit) {
                group.add(pairs.get(j));
                j++;
            }

            // process values
            List<Integer> indices = new ArrayList<>();
            List<Integer> values = new ArrayList<>();

            for (int[] p : group) {
                values.add(p[0]);
                indices.add(p[1]);
            }

            Collections.sort(indices);
            Collections.sort(values);

            for (int k = 0; k < indices.size(); k++) {
                res[indices.get(k)] = values.get(k);
            }
            i = j;
        }
        return res;
    }
}
