package com.leetcode_practice.contest.biweekly.count_172;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxSumOfThreeNumbersDivisibleByThree_3780 {
    public int maximumSum_BF(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if ((nums[i] + nums[j] + nums[k]) % 3 == 0) {
                        return (nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return 0;
    }

    public int maximumSum(int[] nums) {
        List<Integer> b0 = new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        List<Integer> b2 = new ArrayList<>();

        for (int x : nums) {
            if (x % 3 == 0)
                b0.add(x);
            else if (x % 3 == 1)
                b1.add(x);
            else
                b2.add(x);
        }

        b0.sort(Collections.reverseOrder());
        b1.sort(Collections.reverseOrder());
        b2.sort(Collections.reverseOrder());

        int ans = 0;

        // 0 + 0 + 0
        if (b0.size() >= 3)
            ans = Math.max(ans, b0.get(0) + b0.get(1) + b0.get(2));

        // 1 + 1 + 1
        if (b1.size() >= 3)
            ans = Math.max(ans, b1.get(0) + b1.get(1) + b1.get(2));

        // 2 + 2 + 2
        if (b2.size() >= 3)
            ans = Math.max(ans, b2.get(0) + b2.get(1) + b2.get(2));

        // 0 + 1 + 2
        if (b0.size() >= 1 && b1.size() >= 1 && b2.size() >= 1)
            ans = Math.max(ans, b0.get(0) + b1.get(0) + b2.get(0));

        return ans;
    }

}