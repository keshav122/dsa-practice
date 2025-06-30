package com.dsa_series.roadmap.sliding_window_and_two_pointers.counting_subarrays_substrings_problems;

public class CountNumberOfNiceSubarrays {
    public int numberOfOddSubarrays_BF(int[] nums, int k) {
        int n = nums.length;
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            int oddCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 1) {
                    oddCount++;
                }
                if (oddCount == k) {
                    totalCount++;
                }
                if (oddCount > k) {
                    break;
                }
            }
        }
        return totalCount;
    }

    public int numberOfOddSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    public int helper(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int n = nums.length;
        int count = 0, l = 0, r = 0, sum = 0;
        while (r < n) {
            sum += nums[r] % 2;
            while (sum > goal) {
                sum -= nums[l] % 2;
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}
