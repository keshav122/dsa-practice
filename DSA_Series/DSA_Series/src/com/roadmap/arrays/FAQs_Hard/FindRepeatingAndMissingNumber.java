package com.roadmap.arrays.FAQs_Hard;

import java.util.HashMap;
import java.util.Map;

public class FindRepeatingAndMissingNumber {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        long naturalSum = ((n + 1) * n) / 2;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            sum += num;
            if (map.containsKey(num)) {
                ans[0] = num;
            } else {
                map.put(num, 1);
            }
        }
        if (sum > naturalSum) {
            ans[1] = (int) (ans[0] - (sum - naturalSum));
        } else {
            ans[1] = (int) (ans[0] + (naturalSum - sum));
        }

        return ans;
    }
}
