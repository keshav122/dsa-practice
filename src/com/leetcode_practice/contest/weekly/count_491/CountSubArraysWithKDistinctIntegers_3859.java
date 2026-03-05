package com.leetcode_practice.contest.weekly.count_491;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*You are given an integer array nums and two integers k and m.

Return an integer denoting the count of subarrays of nums such that:

The subarray contains exactly k distinct integers.
Within the subarray, each distinct integer appears at least m times. */
//TODO - Solve this one - Passed 1035/1075 cases
public class CountSubArraysWithKDistinctIntegers_3859 {
    public long countSubarrays(int[] nums, int k, int m) {
        long ans = 0;
        int l = 0, r = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        while (r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            set.add(nums[r]);
            if (set.size() == k && count(set, map, m)) {
                ans++;
            }

            while (set.size() > k && l < r) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) <= 0) {
                    map.remove(nums[l]);
                    set.remove(nums[l]);
                }
                if (set.size() == k && count(set, map, m)) {
                    ans++;
                }
                l++;
            }

            r++;
        }
        while (set.size() >= k && l < n) {
            map.put(nums[l], map.get(nums[l]) - 1);
            if (map.get(nums[l]) <= 0) {
                map.remove(nums[l]);
                set.remove(nums[l]);
            }
            if (set.size() == k && count(set, map, m)) {
                ans++;
            }
            l++;
        }

        return ans;
    }

    private boolean count(Set<Integer> set, Map<Integer, Integer> map, int m) {
        for (Integer i : set) {
            if (!map.containsKey(i) || map.get(i) < m)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 6, 6, 3, 3, };
        int k = 2;
        int m = 2;
        CountSubArraysWithKDistinctIntegers_3859 c = new CountSubArraysWithKDistinctIntegers_3859();
        System.out.println(c.countSubarrays(nums, k, m));
    }
}
