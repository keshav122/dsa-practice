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
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0, distinct = 0, good = 0, extra = 0;
        for (int r = 0; r < nums.length; r++) {
            int x = nums[r];
            freq.put(x, freq.getOrDefault(x, 0) + 1);

            if (freq.get(x) == 1)
                distinct++;
            if (freq.get(x) == m)
                good++;

            while (distinct > k) {
                int y = nums[l++];
                extra = 0;

                if (freq.get(y) == m)
                    good--;
                freq.put(y, freq.get(y) - 1);

                if (freq.get(y) == 0) {
                    freq.remove(y);
                    distinct--;
                }

            }

            while (distinct == k && good == k && freq.get(nums[l]) > m) {
                freq.put(nums[l], freq.get(nums[l]) - 1);
                l++;
                extra++;
            }

            if (distinct == k && good == k) {
                ans += extra + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 6, 6, 3, 3, };
        int k = 2;
        int m = 2;
        CountSubArraysWithKDistinctIntegers_3859 c = new CountSubArraysWithKDistinctIntegers_3859();
        System.out.println(c.countSubarrays(nums, k, m));
    }
}
