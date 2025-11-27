package com.leetcode_practice.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5_1018 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        long val = nums[0];
        List<Boolean> ans = new ArrayList<>();
        ans.add(val == 0);
        for (int i = 1; i < n; i++) {
            val = val * 2 + nums[i];
            ans.add((val % 5) == 0);
        }
        return ans;
    }
}
