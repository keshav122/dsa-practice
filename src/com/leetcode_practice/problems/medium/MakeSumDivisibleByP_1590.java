package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP_1590 {

    public int minSubarray_BF(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int mod = (int) (sum % p);
        if (mod == 0)
            return 0;
        // Now we need to find min length subarray which is equal to mod or
        // equal to product of mod
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long curr = 0;
            for (int j = i; j < n; j++) {
                curr += nums[j];
                if (curr % p == mod) {
                    len = Math.min(j - i + 1, len);
                }
            }

        }
        return (len == Integer.MAX_VALUE || len == n) ? -1 : len;
    }

    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        int mod = (int) (total % p);
        if (mod == 0)
            return 0;

        Map<Integer, Integer> lastIndex = new HashMap<>();
        lastIndex.put(0, -1);
        long prefix = 0;
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int need = (int) ((prefix - mod + p) % p);
            if (lastIndex.containsKey(need)) {
                res = Math.min(res, i - lastIndex.get(need));
            }
            lastIndex.put((int) prefix, i);
        }
        return res == nums.length ? -1 : res;
    }

    public static void main(String[] args) {
        int[] nums = { 26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3 };
        int p = 26;
        MakeSumDivisibleByP_1590 m = new MakeSumDivisibleByP_1590();
        System.out.println(m.minSubarray(nums, p));
    }
}
