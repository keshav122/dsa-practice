package com.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleByP_1590 {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long subArraySum = sum % p;
        if (subArraySum == 0)
            return 0;
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
