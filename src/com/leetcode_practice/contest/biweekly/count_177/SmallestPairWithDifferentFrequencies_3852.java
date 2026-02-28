package com.leetcode_practice.contest.biweekly.count_177;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SmallestPairWithDifferentFrequencies_3852 {
    public int[] minDistinctFreqPair(int[] nums) {
        int[] ans = { -1, -1 };
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Set<Integer> keys = freq.keySet();
        List<Integer> li = new ArrayList<>();
        li.addAll(keys);
        Collections.sort(li);
        for (int i = 0; i < li.size() - 1; i++) {
            for (int j = i + 1; j < li.size(); j++) {
                if (freq.get(li.get(i)) != freq.get(li.get(j))) {
                    ans[0] = li.get(i);
                    ans[1] = li.get(j);
                    return ans;
                }
            }
        }
        return ans;
    }
}
