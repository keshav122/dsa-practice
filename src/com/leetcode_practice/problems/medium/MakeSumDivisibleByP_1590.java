package com.leetcode_practice.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP_1590 {

    public int minSubarray_BF(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % p == 0)
            return 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long curr = 0;
            for (int j = i; j < Math.min(n, i + n - 1); j++) {
                curr += nums[j];
                if ((sum - curr) % p == 0) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;

    }

    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int mod = (int) (sum % p);
        if (mod == 0)
            return 0;

        // We need to fin min Length subarray whose sum is divisible by mod

        return minLenSubArraySum(nums, subArraySum);
    }

    // This method should return the minimum length of the subarray
    // whose sum is equal to the 'subArraySum' . if there is no such subarray
    // return -1
    private int minLenSubArraySum(int[] nums, long subArraySum) {
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        Map<Long, Integer> subArraySumMap = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (!subArraySumMap.containsKey(sum)) {
                subArraySumMap.put(sum, i);
            }
            if (subArraySumMap.containsKey(subArraySum)) {
                minLen = Math.min(minLen, i + 1);
            }
            if (subArraySumMap.containsKey(sum - subArraySum)) {
                minLen = Math.min(minLen, i - subArraySumMap.get(sum - subArraySum));
            }
        }
        if (minLen == n || minLen == Integer.MAX_VALUE) {
            return -1;
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = { 26, 19, 11, 14, 18, 4, 7, 1, 30, 23, 19, 8, 10, 6, 26, 3 };
        int p = 26;
        MakeSumDivisibleByP_1590 m = new MakeSumDivisibleByP_1590();
        System.out.println(m.minSubarray(nums, p));
    }
}
