package com.dsa_series.roadmap.arrays.FAQs_Medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum_BF(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int desiredVal = target - nums[i];
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] == desiredVal) {
                    ans[0] = Math.min(i, j);
                    ans[1] = Math.max(i, j);
                    return ans;
                }
            }
        }

        ans[0] = ans[1] = -1;
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> elementIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (elementIndexMap.containsKey(val)) {
                ans[0] = elementIndexMap.get(val);
                ans[1] = i;
                return ans;
            } else {
                elementIndexMap.put(nums[i], i);
            }
        }
        ans[0] = ans[1] = -1;
        return ans;
    }
}
