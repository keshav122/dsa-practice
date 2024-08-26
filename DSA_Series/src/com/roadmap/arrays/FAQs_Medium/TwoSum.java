package com.roadmap.arrays.FAQs_Medium;

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
            // Special case where same element is present twice and their sum is
            // equal to the target
            if (elementIndexMap.containsKey(nums[i]) && target == 2 * nums[i]) {
                int indexPresent = elementIndexMap.get(nums[i]);
                ans[0] = Math.min(i, indexPresent);
                ans[1] = Math.max(i, indexPresent);
                return ans;
            } else {
                elementIndexMap.put(nums[i], i);
            }
        }

        for (Map.Entry<Integer, Integer> entry : elementIndexMap.entrySet()) {
            if (elementIndexMap.containsKey(target - entry.getKey())) {
                int key = elementIndexMap.get(target - entry.getKey());
                ans[0] = Math.min(entry.getValue(), key);
                ans[1] = Math.max(entry.getValue(), key);
                return ans;
            }
        }

        ans[0] = ans[1] = -1;
        return ans;
    }
}
