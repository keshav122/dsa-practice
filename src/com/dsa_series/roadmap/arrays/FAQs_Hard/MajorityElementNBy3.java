package com.dsa_series.roadmap.arrays.FAQs_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementNBy3 {

    public List<Integer> majorityElementTwo_BF(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > (nums.length / 3)) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }

    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int candidate1 = nums[0], candidate1Count = 1;
        int candidate2 = nums[0], candidate2Count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == candidate1) {
                candidate1Count++;
            } else if (nums[i] == candidate2) {
                candidate2Count++;
            } else {
                candidate1Count--;
                candidate2Count--;
                if (candidate1Count == 0) {
                    candidate1 = nums[i];
                    candidate1Count++;
                } else if (candidate2Count == 0) {
                    candidate2 = nums[i];
                    candidate2Count++;
                }
            }
        }

        int c1Count = 0;
        int c2Count = 0;
        for (int num : nums) {
            if (num == candidate1) {
                c1Count++;
            }
            if (num == candidate2) {
                c2Count++;
            }
        }
        if (c1Count > (n / 3)) {
            ans.add(candidate1);
        }

        if (c2Count > (n / 3) && !ans.contains(candidate2)) {
            ans.add(candidate2);
        }
        return ans;
    }
}
