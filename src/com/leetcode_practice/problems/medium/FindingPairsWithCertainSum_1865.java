package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class FindingPairsWithCertainSum_1865 {

    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map2 = new HashMap<>();

    public FindingPairsWithCertainSum_1865(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        for (int num : nums2) {
            map2.merge(num, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        map2.put(nums2[index], map2.get(nums2[index]) - 1);
        nums2[index] += val;
        map2.merge(nums2[index], 1, Integer::sum);
    }

    public int count(int tot) {
        int cnt = 0;
        for (int num : nums1) {
            cnt += map2.getOrDefault(tot - num, 0);
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */

class FindSumPairs {

    int[] nums1;
    int[] nums2;
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        for (int num : nums1) {
            map1.merge(num, 1, Integer::sum);
        }
        for (int num : nums2) {
            map2.merge(num, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        map2.put(nums2[index], map2.get(nums2[index]) - 1);
        nums2[index] += val;
        map2.merge(nums2[index], 1, Integer::sum);
    }

    public int count(int tot) {
        int cnt = 0;
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(tot - key)) {
                cnt += (map1.get(key) * map2.get(tot - key));
            }
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
